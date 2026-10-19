# UML Final — Enunciado C: Sistema de Recomendación Académica
### Documento de diseño — Elaborado por el docente

Este documento es **el contrato de diseño** del parcial. El código que
implementes debe respetar exactamente estas clases, atributos, métodos y
relaciones. No se permite agregar ni eliminar clases.

---

## 1. Diagrama de clases

```
                    +----------------------+
                    |   <<abstract>>       |
                    |       Curso          |
                    +----------------------+
                    | - codigo: String     |
                    | - nombre: String     |
                    | - creditos: int      |
                    +----------------------+
                    | + Curso(codigo, nombre, creditos) |
                    | + dificultadEsperada():double {abstract} |
                    | + getCodigo():String |
                    | + getNombre():String |
                    | + getCreditos():int  |
                    +----------△-----------+
                               │
          ┌────────────────────┼────────────────────┐
          │                    │                    │
+---------------------+ +-------------------+ +-----------------------+
| CursoObligatorio    | |  CursoElectivo    | |  CursoNivelatorio     |
+---------------------+ +-------------------+ +-----------------------+
| + CursoObligatorio(codigo, nombre, creditos) | + CursoElectivo(codigo, nombre, creditos) | + CursoNivelatorio(codigo, nombre, creditos) |
| + dificultadEsperada() | + dificultadEsperada() | + dificultadEsperada() |
+---------------------+ +-------------------+ +-----------------------+

+--------------------------+  ◆ (composición)   +-----------------+
|      PlanEstudios        |◆──────────────────>|     Curso       |
+--------------------------+ 1..*               +-----------------+
| - nombre: String         |
| - cursos: ArrayList<Curso> |
+--------------------------+
| + PlanEstudios(nombre:String) |
| - agregarCurso(c:Curso):void {private} |
| + dificultadPromedio():double |
| + getNombre():String |
| + getCursos():ArrayList<Curso> |
+--------------------------+
          △
          │ ◇ (agregación) 1..*
          │
+--------------------------+
|        Facultad          |
+--------------------------+
| - nombre: String         |
| - planes: ArrayList<PlanEstudios> |
+--------------------------+
| + Facultad(nombre:String) |
| + agregarPlan(p:PlanEstudios):void |
| + totalCursos():int      |
| + getNombre():String |
| + getPlanes():ArrayList<PlanEstudios> |
+--------------------------+

+------------------------+     ——— (asociación N:M)  +-----------------+
|      Estudiante        |──────────────────────────>|      Curso      |
+------------------------+                           +-----------------+
| - nombre: String       |
| - notas: int[]         |
| - contadorNotas: int   |
| - inscritos:ArrayList<Curso> |
+------------------------+
| + Estudiante(nombre:String, maxNotas:int) |
| + registrarNota(n:int):void |
| + promedio():double    |
| + inscribirCurso(c:Curso):void |
| + getNombre():String |
| + getNotas():int[]     |
| + getContadorNotas():int |
| + getInscritos():ArrayList<Curso> |
+------------------------+

+----------------+      ⇢ (dependencia)      +-----------------------+
|  Recomendador  |──────────────────────────>|  HistorialAcademico   |
+----------------+   usa en recomendar()     +-----------------------+
| + recomendar(h:HistorialAcademico):List<Curso> | - estudiante: Estudiante |
                                                | + HistorialAcademico(e:Estudiante) |
                                                | + promedio():double |
                                                | + cantidadCursos():int |
                                                | + getEstudiante():Estudiante |
                                                +-----------------------+
```

---

## 2. Las cinco relaciones — justificación

### 2.1 Herencia — `Curso` → `CursoObligatorio` / `CursoElectivo` / `CursoNivelatorio`
Los tres tipos **son** cursos. Comparten código, nombre y créditos, pero
difieren en la dificultad esperada. Se modela con clase abstracta `Curso` y
método abstracto `dificultadEsperada()`.

### 2.2 Composición — `PlanEstudios ◆— Curso`
Los cursos **pertenecen** al plan: se crean dentro del constructor del plan
y no tienen vida útil propia fuera de él. Si el plan se destruye, sus cursos
también. Se implementa creando los cursos **dentro** de `PlanEstudios` usando
el método privado `agregarCurso(...)`.

### 2.3 Agregación — `Facultad ◇— PlanEstudios`
Los planes **pueden existir** sin la facultad. Se crean independientemente y
luego se registran con `agregarPlan()`. La facultad solo mantiene referencias
en su `ArrayList<PlanEstudios>`.

### 2.4 Asociación — `Estudiante — Curso` (N:M)
Un estudiante cursa varios cursos y un curso puede ser cursado por varios
estudiantes. No hay propiedad; solo referencia mutua por atributo
(`ArrayList<Curso>`).

### 2.5 Dependencia — `Recomendador ⇢ HistorialAcademico`
`Recomendador` **usa** `HistorialAcademico` en un método puntual
(`recomendar`), pero no lo guarda como atributo. Se pasa como parámetro.

---

## 3. Reglas de negocio implícitas

Estas reglas no se derivan del UML, pero los tests JUnit las validan:

1. `PlanEstudios(nombre)` debe crear **al menos un curso de cada tipo**
   (obligatorio, electivo, nivelatorio) dentro del constructor, usando el
   método privado `agregarCurso(...)`. Los tests verifican que exista al menos
   uno de cada uno.
2. `Estudiante.registrarNota(int)` respeta la capacidad del arreglo `notas`.
   Si `contadorNotas >= notas.length`, la nota **no** se registra y el
   contador no aumenta.
3. `Estudiante.promedio()` retorna `0` si no hay notas.
4. `Estudiante.inscribirCurso(Curso)` no debe duplicar cursos. Si el curso ya
   está en `inscritos`, se ignora.
5. `CursoObligatorio.dificultadEsperada()` > `CursoElectivo.dificultadEsperada()`
   > `CursoNivelatorio.dificultadEsperada()`.
   Fórmulas sugeridas:
   - Obligatorio: `1.5 * creditos`
   - Electivo: `1.0 * creditos`
   - Nivelatorio: `0.5 * creditos`
6. `PlanEstudios.dificultadPromedio()` retorna `0` si no hay cursos.
7. `Facultad.totalCursos()` suma los cursos de todos sus planes.
8. `HistorialAcademico.promedio()` y `.cantidadCursos()` delegan en el
   estudiante.
9. `Recomendador.recomendar(HistorialAcademico)`:
   - Si `historial.promedio() >= 4.0`, devuelve los cursos **electivos**
     del estudiante (`instanceof CursoElectivo`).
   - Si `historial.promedio() < 4.0`, devuelve los cursos **nivelatorios**
     (`instanceof CursoNivelatorio`).
   - Si no hay cursos que cumplan la regla, retorna lista vacía (no `null`).

---

## 4. Firmas exactas de los métodos

Las firmas están dadas en el código base de `src/`. Tu tarea es implementar
sus cuerpos, **no cambiar sus firmas**.

| Clase | Método | Retorno esperado |
|---|---|---|
| `CursoObligatorio` | `dificultadEsperada()` | `double` |
| `CursoElectivo` | `dificultadEsperada()` | `double` |
| `CursoNivelatorio` | `dificultadEsperada()` | `double` |
| `PlanEstudios` | constructor `(String)` | — (crea cursos) |
| `PlanEstudios` | `dificultadPromedio()` | `double` |
| `Facultad` | `agregarPlan(PlanEstudios)` | `void` |
| `Facultad` | `totalCursos()` | `int` |
| `Estudiante` | `registrarNota(int)` | `void` |
| `Estudiante` | `promedio()` | `double` |
| `Estudiante` | `inscribirCurso(Curso)` | `void` |
| `HistorialAcademico` | `promedio()` | `double` |
| `HistorialAcademico` | `cantidadCursos()` | `int` |
| `Recomendador` | `recomendar(HistorialAcademico)` | `List<Curso>` |

---

## 5. Lo que NO debes hacer

- No agregar clases nuevas.
- No cambiar firmas de métodos existentes.
- No modificar la carpeta `test/`.
- No convertir atributos privados en públicos.
- No hacer que `PlanEstudios` reciba los cursos ya instanciados desde afuera
  (rompe la composición).
- No hacer que `Recomendador` guarde el historial como atributo
  (rompe la dependencia).
- No duplicar la lógica de `promedio()` en `HistorialAcademico`: debe
  delegar en `Estudiante.promedio()`.