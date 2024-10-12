package modelos;

import utilidades.Utilidad;

import java.util.List;

public class Alumno{
    protected String rut, nombre, apellido, direccion;
    protected List<Materia> materiaList;

    public Alumno() {
        Utilidad.mostrarMensajes("--- Crear Alumno ---");
        setRut();
        setNombre();
        setApellido();
        setDireccion();
    }
    public Alumno(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut() {
        Utilidad.mostrarMensajes("Ingresa RUT: ");
        this.rut = Utilidad.lectura.nextLine();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        Utilidad.mostrarMensajes("Ingresa nombre: ");
        this.nombre = Utilidad.lectura.nextLine();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido() {
        Utilidad.mostrarMensajes("Ingresa apellido: ");
        this.apellido = Utilidad.lectura.nextLine();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion() {
        Utilidad.mostrarMensajes("Ingresa dirección: ");
        this.direccion = Utilidad.lectura.nextLine();
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }
}
