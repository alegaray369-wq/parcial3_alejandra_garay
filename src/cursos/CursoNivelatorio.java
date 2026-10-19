package cursos;

/**
 * Curso nivelatorio. Dificultad base baja.
 */
public class CursoNivelatorio extends Curso {

    public CursoNivelatorio(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    /**
     * TODO estudiante:
     * Devuelve una dificultad calculada según los créditos.
     * Fórmula sugerida: 0.5 * creditos.
     */
    @Override
    public double dificultadEsperada() {
        // TODO: implementar
        return 0;
    }
}