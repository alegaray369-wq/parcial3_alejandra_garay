package cursos;

/**
 * Curso obligatorio. Dificultad base alta.
 */
public class CursoObligatorio extends Curso {

    public CursoObligatorio(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    /**
     * TODO estudiante:
     * Devuelve una dificultad calculada según los créditos.
     * Fórmula sugerida: 1.5 * creditos.
     */
    @Override
    public double dificultadEsperada() {
        // TODO: implementar
        return 0;
    }
}