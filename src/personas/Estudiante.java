package personas;

import cursos.Curso;
import java.util.ArrayList;

/**
 * Estudiante con notas en un arreglo de capacidad fija (int[])
 * y cursos inscritos en un ArrayList (asociación N:M con Curso).
 */
public class Estudiante {

    private String nombre;
    private int[] notas;
    private int contadorNotas;
    private ArrayList<Curso> inscritos;

    public Estudiante(String nombre, int maxNotas) {
        this.nombre = nombre;
        this.notas = new int[maxNotas];
        this.contadorNotas = 0;
        this.inscritos = new ArrayList<>();
    }

    /**
     * Registra una nota. Si el arreglo está lleno, no se registra.
     */
    public void registrarNota(int nota) {
        // TODO: implementar
    }

    /**
     * Promedio de las notas registradas. Retorna 0 si no hay notas.
     */
    public double promedio() {
        // TODO: implementar
        return 0;
    }

    /** Asocia al estudiante con un curso (no lo crea). */
    public void inscribirCurso(Curso curso) {
        // TODO: implementar
    }

    public String getNombre() { return nombre; }
    public int[] getNotas() { return notas; }
    public int getContadorNotas() { return contadorNotas; }
    public ArrayList<Curso> getInscritos() { return inscritos; }
}