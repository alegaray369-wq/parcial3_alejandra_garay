package cursos;

/**
 * Clase abstracta que representa un curso del plan de estudios.
 * Cada subclase define su dificultad esperada.
 */
public abstract class Curso {

    private String codigo;
    private String nombre;
    private int creditos;

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    /**
     * Cada subclase implementa cómo se calcula la dificultad esperada
     * del curso según su tipo (polimorfismo).
     */
    public abstract double dificultadEsperada();

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
}