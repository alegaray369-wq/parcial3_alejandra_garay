import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cursos.*;
import personas.Estudiante;

public class EstudianteTest {

    @Test
    void registrarNotasYCalcularPromedio() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(4);
        e.registrarNota(5);
        assertEquals(4.5, e.promedio(), 0.01);
    }

    @Test
    void promedioCeroSinNotas() {
        Estudiante e = new Estudiante("Ana", 5);
        assertEquals(0.0, e.promedio(), 0.01);
    }

    @Test
    void arregloRespetaCapacidad() {
        Estudiante e = new Estudiante("Ana", 3);
        e.registrarNota(4);
        e.registrarNota(4);
        e.registrarNota(4);
        e.registrarNota(4); // debe ignorarse
        assertEquals(3, e.getContadorNotas());
        assertEquals(3, e.getNotas().length);
    }

    @Test
    void inscribirCursosAsociaSinCrear() {
        Estudiante e = new Estudiante("Ana", 5);
        Curso c = new CursoObligatorio("OBL1", "Cálculo", 4);
        e.inscribirCurso(c);
        e.inscribirCurso(c); // no duplica
        assertEquals(1, e.getInscritos().size());
        assertSame(c, e.getInscritos().get(0));
    }
}