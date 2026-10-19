# Comprensión del diseño — Enunciado C
**Nombre:** Maria Alejandra Garay Igua
**Fecha:** 19/10/26

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Curso` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> `Curso` es abstracta porque no existe un "curso genérico": todo curso es obligatorio, electivo o nivelatorio. Concentra lo común (código, nombre, créditos) y obliga a cada subclase a implementar `dificultadEsperada()`.

---

### 2. Composición vs. agregación
Explica la diferencia entre `PlanEstudios ◆— Curso` (composición) y
`Facultad ◇— PlanEstudios` (agregación). ¿Qué pasaría con los cursos si se
elimina el plan? ¿Y con los planes si se elimina la facultad?

> En la composición  el plan crea sus cursos en el constructor y estos no tienen vida propia: si el plan se elimina, sus cursos desaparecen con él. En la agregación los planes se crean afuera y la facultad solo guarda referencias

---

### 3. Asociación
En `Estudiante — Curso`, ¿quién es dueño de quién? ¿Por qué se modela como
N:M y no como composición?

> Ninguno es dueño del otro: el estudiante solo guarda referencias en su `ArrayList<Curso>` a cursos que ya existen. Es N:M porque un estudiante cursa varios cursos y un mismo curso lo cursan varios estudiantes. No es composición porque el curso no nace ni muere con el estudiante; si el estudiante se va, el curso sigue existiendo.

---

### 4. Dependencia
¿Por qué `Recomendador` **depende** de `HistorialAcademico` en lugar de
**tenerlo** como atributo? ¿Qué ventaja tiene pasar el servicio como
parámetro?

> Porque `Recomendador` solo necesita el historial durante la llamada a `recomendar()`; no es parte de su estado. Pasarlo como parámetro mantiene al recomendador sin estado, reutilizable con cualquier estudiante, menos acoplado y más fácil de probar (se le pasa un historial distinto en cada test).

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] notas` en `Estudiante`
- `ArrayList<Curso>` en `PlanEstudios` y `Estudiante`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
pasa si el estudiante intenta registrar más notas que la capacidad del
arreglo?

> El `int[]` se usa para las notas porque su cantidad máxima es fija y conocida (`maxNotas`) y son datos primitivos, así el arreglo es simple y eficiente. El `ArrayList<Curso>` se usa donde la cantidad de elementos varía, ya que crece dinámicamente. Si se registran más notas que la capacidad, `registrarNota` no la guarda y el contador no aumenta, evitando un `ArrayIndexOutOfBoundsException`.