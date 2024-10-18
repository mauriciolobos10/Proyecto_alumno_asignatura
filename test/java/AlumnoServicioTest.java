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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

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

        // crea las instancias para usar en las pruebas
        mapu = new Alumno("15", "Mapu");
        matematicas = new Materia(MateriaEnum.MATEMATICA);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);
    }
    @Test
    void crearAlumnoTest() {
        alumnoServicioMock.crearAlumno(mapu);

        // verifica que se haya llamado bien al metodo
        verify(alumnoServicioMock).crearAlumno(mapu);

    }
    @Test
    void agregarMateriaTest() {
        alumnoServicioMock.agregarMateria(mapu.getRut(), matematicas);

        verify(alumnoServicioMock).agregarMateria(mapu.getRut(), matematicas);
    }
    @Test
    void materiasPorAlumnosTest() {
        alumnoServicioMock.materiasPorAlumnos(mapu.getRut());

        verify(alumnoServicioMock).materiasPorAlumnos(mapu.getRut());
    }
    @Test
    void listarAlumnosTest() {
        alumnoServicioMock.listarAlumnos();

        verify(alumnoServicioMock).listarAlumnos();
    }
}
