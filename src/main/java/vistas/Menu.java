package vistas;

import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate{
    private AlumnoServicio alumnoServicio;
    private ArchivoServicio archivoServicio;
    public Menu(){}

    @Override
    public void exportarDatos() {

    }

    @Override
    public void crearAlummno() {

    }

    @Override
    public void agregarMateria() {

    }

    @Override
    public void agregarNotaPasoUno() {

    }

    @Override
    public void listarAlumnos() {
        alumnoServicio.listarAlumnos();
    }

    @Override
    public void terminarPrograma() {

    }
}
