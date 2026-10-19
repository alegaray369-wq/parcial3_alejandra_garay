package cursos;

/**
 * Curso electivo. Dificultad base media.
 */
public class CursoElectivo extends Curso {

    public CursoElectivo(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    /**
     * TODO estudiante:
     * Devuelve una dificultad calculada según los créditos.
     * Fórmula sugerida: 1.0 * creditos.
     */
    @Override
    public double dificultadEsperada() {
        // TODO: implementar
        return 0;
    }
}