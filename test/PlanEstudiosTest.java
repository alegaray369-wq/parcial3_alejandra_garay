import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import plan.PlanEstudios;

public class PlanEstudiosTest {

    @Test
    void planComponeCursosAlCrearse() {
        PlanEstudios p = new PlanEstudios("Ing. Datos");
        assertTrue(p.getCursos().size() >= 1);
    }

    @Test
    void planTieneAlMenosUnCursoDeCadaTipo() {
        PlanEstudios p = new PlanEstudios("Ing. Datos");
        boolean tieneObligatorio = false, tieneElectivo = false, tieneNivelatorio = false;
        for (var c : p.getCursos()) {
            String tipo = c.getClass().getSimpleName();
            if (tipo.equals("CursoObligatorio")) tieneObligatorio = true;
            if (tipo.equals("CursoElectivo")) tieneElectivo = true;
            if (tipo.equals("CursoNivelatorio")) tieneNivelatorio = true;
        }
        assertTrue(tieneObligatorio);
        assertTrue(tieneElectivo);
        assertTrue(tieneNivelatorio);
    }

    @Test
    void dificultadPromedioPositiva() {
        PlanEstudios p = new PlanEstudios("Ing. Datos");
        assertTrue(p.dificultadPromedio() > 0);
    }
}