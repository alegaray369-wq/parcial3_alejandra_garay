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
        if (plan != null && !planes.contains(plan)) {
            planes.add(plan);
        }
    }

    /**
     * Total de cursos de todos los planes de la facultad.
     */
    public int totalCursos() {
        int total = 0;
        for (PlanEstudios plan : planes) {
            total += plan.getCursos().size();
        }
        return total;
    }

    public String getNombre() { return nombre; }
    public ArrayList<PlanEstudios> getPlanes() { return planes; }
}