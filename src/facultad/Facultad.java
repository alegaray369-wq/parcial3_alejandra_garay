package facultad;

import plan.PlanEstudios;
import java.util.ArrayList;

/**
 * Facultad que AGREGA planes de estudio.
 */
public class Facultad {

    private String nombre;
    private ArrayList<PlanEstudios> planes;

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.planes = new ArrayList<>();
    }

    /** Agrega un plan ya existente (agregación). */
    public void agregarPlan(PlanEstudios plan) {
        // TODO: implementar
    }

    /**
     * Total de cursos de todos los planes de la facultad.
     */
    public int totalCursos() {
        // TODO: implementar
        return 0;
    }

    public String getNombre() { return nombre; }
    public ArrayList<PlanEstudios> getPlanes() { return planes; }
}