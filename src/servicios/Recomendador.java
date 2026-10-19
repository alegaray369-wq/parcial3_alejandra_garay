package servicios;

import cursos.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 * Recomendador que DEPENDE de HistorialAcademico.
 * Se pasa el historial como parámetro (no se guarda como atributo).
 */
public class Recomendador {

    /**
     * TODO estudiante:
     * Recibe un HistorialAcademico y retorna una lista de cursos recomendados.
     * Regla sugerida:
     *   - Si el promedio es >= 4.0, recomendar cursos electivos.
     *   - Si el promedio es < 4.0, recomendar cursos nivelatorios.
     * La lista puede estar vacía si no hay cursos disponibles.
     */
    public List<Curso> recomendar(HistorialAcademico historial) {
        // TODO: implementar
        return new ArrayList<>();
    }
}