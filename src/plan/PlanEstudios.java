package plan;

import cursos.*;
import java.util.ArrayList;

/**
 * Plan de estudios que COMPONE cursos.
 * Los cursos se crean dentro del constructor (composición real).
 */
public class PlanEstudios {

    private String nombre;
    private ArrayList<Curso> cursos;

    public PlanEstudios(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
        // TODO: crear los cursos del plan aquí dentro
        // Ejemplo esperado: agregar 3 cursos (obligatorio, electivo, nivelatorio)
        // usando el método privado agregarCurso(...).
    }

    /**
     * Método privado para agregar cursos desde el propio constructor.
     * Solo el plan puede crear sus cursos (composición).
     */
    private void agregarCurso(Curso curso) {
        // TODO: implementar
    }

    /**
     * Promedio de dificultad de todos los cursos del plan.
     * Retorna 0 si el plan no tiene cursos.
     */
    public double dificultadPromedio() {
        // TODO: implementar
        return 0;
    }

    public String getNombre() { return nombre; }
    public ArrayList<Curso> getCursos() { return cursos; }
}