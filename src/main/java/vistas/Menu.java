package vistas;

import modelos.Alumno;
import modelos.Materia;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;
import utilidades.Utilidad;

import java.util.ArrayList;

public class Menu extends MenuTemplate{
    private AlumnoServicio alumnoServicio;
    private ArchivoServicio archivoServicio;
    public Menu(){
        alumnoServicio = new AlumnoServicio();
        archivoServicio = new ArchivoServicio();
    }

    @Override
    public void exportarDatos() {
        Utilidad.mostrarMensajesTitulos("Exportar Datos");
        if(alumnoServicio.listaDeAlumnos() == null){
            Utilidad.mostrarMensajes("Sin datos que exportar");
            Utilidad.continuedadMenu();
            return;
        }
        Utilidad.mostrarMensajes("Ingresa la ruta en donde se encuentra el archivo notas.csv : ");
        String ruta = this.lectura.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listaDeAlumnos(), ruta);
    }

    @Override
    public void crearAlummno() {
        Alumno alumno = new Alumno();
        Utilidad.mostrarMensajesTitulos("Crear Alumno");
        alumno.setRut();
        alumno.setNombre();
        alumno.setApellido();
        alumno.setDireccion();
        alumno.setMateriaList(new ArrayList<>());
        alumnoServicio.crearAlumno(alumno);
        Utilidad.mostrarMensajesTitulos("¡Alumno agregado!");
    }

    @Override
    public void agregarMateria() {
        Utilidad.mostrarMensajesTitulos("Agregar Materia");
        Alumno alumno = alumnoServicio.buscarAlumno();
        if(alumno != null){
            String stringAlumno = "";
            boolean existe = false;
            do {
                Materia nuevaMateria = new Materia();
                if(nuevaMateria.getNombre() == null){
                    return;
                }
                for (Materia materia : alumno.getMateriaList()) {
                    if (materia.getNombre().equals(nuevaMateria.getNombre())) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    // Si no existe, la agregamos
                    alumno.getMateriaList().add(nuevaMateria);
                    Utilidad.mostrarMensajes("Materia agregada correctamente.");
                    return;
                } else {
                    // Si ya existe, mostramos un mensaje
                    Utilidad.mostrarMensajes("La materia ya está registrada para este alumno.");
                }
            } while (!stringAlumno.equals("9"));
        }
    }

    @Override
    public void agregarNotaPasoUno() {
        Utilidad.mostrarMensajesTitulos("Agregar Nota");
        Alumno alumno = alumnoServicio.buscarAlumno();
        alumnoServicio.ingresarNotaMateria(alumno);
    }

    @Override
    public void listarAlumnos() {
        alumnoServicio.listarAlumnos();
    }

    @Override
    public void terminarPrograma() {

    }
}
