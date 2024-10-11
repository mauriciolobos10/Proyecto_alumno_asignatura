package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.util.List;
import java.util.Map;

import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;
    private AlumnoServicioImp alumnoServicio;

    @Mock
    private AlumnoServicioImp alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;

    public void crearAlumno(Alumno alumno){
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria (String rutAlumno, Materia currentMate){
        listaAlumnos.get(rutAlumno).getMateriaList().add(currentMate);
    }
    public List<Materia> materiasPorAlumnos (String rutAlumno){
        return listaAlumnos.get(rutAlumno).getMateriaList();
    }
    public Map<String, Alumno> listarAlumnos(){
        return listaAlumnos;
    }

    @BeforeEach
    void setUp() {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);

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
