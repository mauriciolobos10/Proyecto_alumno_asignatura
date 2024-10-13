package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utilidades.Utilidad;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;
    private AlumnoServicioImp alumnoServicio;

    @Mock
    private AlumnoServicioImp alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;

    public void crearAlumno(Alumno alumno){
        if(listaAlumnos == null){
            listaAlumnos = new HashMap<>();
        }
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria (String rutAlumno, Materia currentMate){
        listaAlumnos.get(rutAlumno).getMateriaList().add(currentMate);
    }
    public List<Materia> materiasPorAlumnos (String rutAlumno){
        return listaAlumnos.get(rutAlumno).getMateriaList();
    }

    public Map<String, Alumno> listaDeAlumnos(){
        return listaAlumnos;
    }

    public void listarAlumnos(){
        if(listaAlumnos == null){
            Utilidad.mostrarMensajes("Lista de alumnos vacia");
        }
        int enumeracion= 1;
        Utilidad.mostrarMensajesTitulos("Listar Alumnos");
        // Se itera sobre el Map de alumnos
        for (Map.Entry<String, Alumno> entry : listaAlumnos.entrySet()) {
            Utilidad.mostrarMensajes("Datos Alumno");
            String clave = entry.getKey();
            Alumno alumno = entry.getValue();

            Utilidad.mostrarMensajes("    RUT: " + alumno.getRut());
            Utilidad.mostrarMensajes("    Nombre: " + alumno.getNombre());
            Utilidad.mostrarMensajes("    Apellido: " + alumno.getApellido());
            Utilidad.mostrarMensajes("    Dirección: " + alumno.getDireccion());
            if(alumno.getMateriaList() == null || alumno.getMateriaList().isEmpty()){
                Utilidad.mostrarMensajes("    Materias: SIN MATERIAS");
            }else{
                Utilidad.mostrarMensajes("    Materias: ");
            }
            for (Materia materia : alumno.getMateriaList()) {
                Utilidad.mostrarMensajes("          " + materia.getNombre().name());
                String notas = "            [";
                for (Double nota : materia.getNotasList()) {
                    notas = notas + nota + ", ";
                }
                // Eliminar la última coma y espacio
                if (notas.length() > 1) { // Asegurarse de que hay al menos un elemento
                    notas = notas.substring(0, notas.length() - 2); // Elimina los últimos dos caracteres (", ")
                    notas += "]";
                }
                Utilidad.mostrarMensajes(notas);
            }
        }
    }

    public Alumno buscarAlumno(){
        String stringAlumno = "";
        Alumno alumno = null;
        do {
            Utilidad.mostrarMensajes("Ingresa rut del Alumno: ");
            stringAlumno = Utilidad.lectura.nextLine();
            if (!stringAlumno.equals("9")) {
                alumno = listaAlumnos.get(stringAlumno);
                if (alumno == null) {
                    Utilidad.mostrarMensajes("Alumno no encontrado");
                    Utilidad.mostrarMensajes("Salir: 9.");
                }else{
                    return alumno;
                }
            } else {
                alumno = null; // para asegurar que no entre nuevamente si eligió salir
            }

        } while (!stringAlumno.equals("9"));
        return listaAlumnos.get(alumno);
    }

    public void ingresarNotaMateria(Alumno alumno){
        Materia materia = null;
        if(alumno.getMateriaList() == null ){
            Utilidad.mostrarMensajes("Alumnos sin materias asignadas: ");
            return;
        }
        Utilidad.mostrarMensajes("Selecciona una Materia: ");
        int opcion = 1;
        for (Materia materiaUnico : alumno.getMateriaList()) {
            Utilidad.mostrarMensajes("Opcion "+opcion+ ":" + materiaUnico.getNombre().name());
            opcion++;
        }
        Utilidad.mostrarMensajes("Salir: 9.");
        int op;
        do {
            op = Utilidad.lectura.nextInt();

            if (op > 0 && op <= MateriaEnum.values().length) {
                materia = alumno.getMateriaList().get(op-1);
                Utilidad.mostrarMensajes("Ingresar nota: ");
                Double nota = Utilidad.lectura.nextDouble();
                materia.getNotasList().add(nota);
                Utilidad.mostrarMensajesTitulos("¡Nota agregada a "+ materia.getNombre().name()+ "!");
                return;
            } else {
                Utilidad.mostrarMensajes("Opción no válida. Seleccione un número entre 1 y " + MateriaEnum.values().length);
            }
        }while (op != 9);
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
