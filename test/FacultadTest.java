import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import facultad.Facultad;
import plan.PlanEstudios;

public class FacultadTest {

    @Test
    void facultadAgregaPlanesExistentes() {
        Facultad f = new Facultad("Ingeniería");
        f.agregarPlan(new PlanEstudios("Plan A"));
        f.agregarPlan(new PlanEstudios("Plan B"));
        assertEquals(2, f.getPlanes().size());
    }

    @Test
    void totalCursosSumaTodosLosPlanes() {
        Facultad f = new Facultad("Ingeniería");
        PlanEstudios p1 = new PlanEstudios("Plan A");
        PlanEstudios p2 = new PlanEstudios("Plan B");
        f.agregarPlan(p1);
        f.agregarPlan(p2);
        int esperado = p1.getCursos().size() + p2.getCursos().size();
        assertEquals(esperado, f.totalCursos());
    }
}