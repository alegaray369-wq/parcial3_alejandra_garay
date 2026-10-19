import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cursos.*;
import java.util.List;
import personas.Estudiante;
import servicios.HistorialAcademico;
import servicios.Recomendador;

public class RecomendadorTest {

    @Test
    void historialReflejaDatosDelEstudiante() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(4);
        e.registrarNota(5);
        e.inscribirCurso(new CursoObligatorio("OBL", "X", 4));
        HistorialAcademico h = new HistorialAcademico(e);
        assertEquals(4.5, h.promedio(), 0.01);
        assertEquals(1, h.cantidadCursos());
    }

    @Test
    void recomendarConBuenPromedioSugiereElectivos() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(5);
        e.registrarNota(5);
        e.inscribirCurso(new CursoElectivo("ELE1", "IA", 4));

        HistorialAcademico h = new HistorialAcademico(e);
        Recomendador r = new Recomendador();
        List<Curso> sugerencias = r.recomendar(h);

        assertFalse(sugerencias.isEmpty());
        assertTrue(sugerencias.get(0) instanceof CursoElectivo);
    }

    @Test
    void recomendarConBajoPromedioSugiereNivelatorios() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(2);
        e.registrarNota(3);
        e.inscribirCurso(new CursoNivelatorio("NIV1", "Intro", 2));

        HistorialAcademico h = new HistorialAcademico(e);
        Recomendador r = new Recomendador();
        List<Curso> sugerencias = r.recomendar(h);

        assertFalse(sugerencias.isEmpty());
        assertTrue(sugerencias.get(0) instanceof CursoNivelatorio);
    }
}