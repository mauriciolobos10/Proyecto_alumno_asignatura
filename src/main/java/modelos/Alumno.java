package modelos;

import utilidades.Utilidad;

import java.util.List;

public class Alumno{
    protected String rut, nombre, apellido, direccion;
    protected List<Materia> materiaList;

    public Alumno() {
        setRut();
        setNombre();
        setApellido();
        setDireccion();
    }

    public String getRut() {
        return rut;
    }

    public void setRut() {
        Utilidad.mostrarMensajes("Ingresa el RUT del alumno");
        this.rut = Utilidad.lectura.nextLine();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        Utilidad.mostrarMensajes("Ingresa el Nombre del alumno");
        this.nombre = Utilidad.lectura.nextLine();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido() {
        Utilidad.mostrarMensajes("Ingresa el Apellido del alumno");
        this.apellido = Utilidad.lectura.nextLine();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion() {
        Utilidad.mostrarMensajes("Ingresa la direccion del alumno");
        this.direccion = Utilidad.lectura.nextLine();
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }
}
