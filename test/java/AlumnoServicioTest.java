import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import servicios.AlumnoServicio;
import servicios.AlumnoServicioImp;

import static org.mockito.Mockito.mock;

public class AlumnoServicioTest {

    private AlumnoServicioImp alumnoServicio;
    @Mock
    private AlumnoServicio alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;

    @BeforeEach
    void setUp() {
        alumnoServicio = new AlumnoServicioImp();
        alumnoServicioMock = mock(AlumnoServicio.class);

        // Crear las instancias de datos de prueba
        mapu = new Alumno("15", "Mapu");
        matematicas = new Materia(MateriaEnum.MATEMATICA);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
    }
    @Test
    void crearAlumnoTest() {
        // Llamar al método real
//        crearAlumno(mapu);

    }
    @Test
    void agregarMateriaTest() {

    }
    @Test
    void materiasPorAlumnosTest() {

    }
    @Test
    void listarAlumnosTest() {

    }
}
