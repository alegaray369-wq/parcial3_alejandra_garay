# Parcial — Estructuras de Datos (2° semestre)
## Enunciado C: Sistema de Recomendación Académica

**Espacio académico:** Estructuras de Datos
**Programa:** Ingeniería en Datos e Inteligencia Artificial
**Duración:** Sesión 1 (3 h) + Sesión 2 (2 h)
**Modalidad:** Individual
**Evaluación:** Según `RUBRICA.md`

---

## 🎯 Contexto del problema

Una universidad desea recomendar materias electivas a sus estudiantes según su
historial académico. Cada **plan de estudios** está compuesto por varias
**materias** (obligatorias, electivas o nivelatorias), y cada **facultad**
agrupa varios planes. Los estudiantes se **asocian** a los cursos que van
cursando, y un **recomendador** sugiere electivas según su desempeño previo.

La plataforma debe poder consultar:
- El promedio de notas de cada estudiante.
- Las materias del plan de estudios de una facultad.
- Recomendaciones personalizadas de electivas.

---

## 📚 Material que ya viene resuelto (NO lo modifiques)

El docente ya realizó **la fase de modelado**. En `docs/UML-final.md`
encontrarás el diagrama completo con clases, atributos, métodos y las cinco
relaciones UML. Ese documento es tu **contrato**: el código que escribas debe
respetarlo tal cual.

También encontrarás `docs/comprension.md`: respóndelo antes de empezar a
programar.

---

## 📋 Lo que TÚ debes hacer

### Sesión 1 (3 h)
1. Clonar el repositorio y crear tu rama personal.
2. Configurar el proyecto en IntelliJ IDEA.
3. Leer `docs/UML-final.md` y responder `docs/comprension.md`.
4. Empezar a implementar los `TODO` de las clases más sencillas:
   `Estudiante.registrarNota`, `Estudiante.promedio`, getters/setters.
5. Primer commit: `comprension: respondo preguntas del UML + primeros TODOs`.

### Sesión 2 (2 h)
6. Implementar el resto de `TODO`:
   - Jerarquía de cursos (`dificultadEsperada()` polimórfico en las 3 subclases).
   - `PlanEstudios` con composición real (crea los cursos internamente).
   - `Facultad` con `ArrayList<PlanEstudios>` (agregación).
   - `Estudiante` asociado a cursos.
   - `Recomendador` que usa `HistorialAcademico` (dependencia).
7. Ejecutar los tests JUnit desde IntelliJ (clic en triángulo verde).
8. Iterar hasta que **todos** los tests pasen.
9. Commit final: `impl: TODOs completados y tests pasando`.
10. Push de tu rama.

⚠️ **NO modifiques la carpeta `test/`.** Si lo haces, se anula el examen.

---

## 🛠️ Configuración en IntelliJ IDEA (paso a paso)

1. **Abrir el proyecto:** `File → Open…` y selecciona la carpeta raíz clonada.
2. **Marcar `src` como Sources Root:** clic derecho → `Mark Directory as → Sources Root`.
3. **Marcar `test` como Test Sources Root:** clic derecho → `Mark Directory as → Test Sources Root`.
4. **Agregar JUnit como librería:**
   - Descarga `junit-platform-console-standalone-1.10.2.jar` de
     https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/
   - Guárdalo en `lib/`.
   - `File → Project Structure → Libraries → + → Java` y selecciona el JAR.
5. **Ejecutar un test:** clic derecho sobre `test/` → `Run 'All Tests'`.
6. **Si algo no compila:** `Build → Rebuild Project`.

---

## 🚀 Configuración del proyecto en Git

```bash
git clone <URL-del-repo-base> parcial-estructuras
cd parcial-estructuras
git checkout -b parcial/tu-nombre-apellido