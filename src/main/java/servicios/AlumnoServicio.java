package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;
    private AlumnoServicioImp alumnoServicio;

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
}
