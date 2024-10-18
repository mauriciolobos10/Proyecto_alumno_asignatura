package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import modelos.MateriaEnum;
import utilidades.Utilidad;

public class AlumnoServicio implements Utilidad{
    private Map<String, Alumno> listaAlumnos;

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
                if (!materia.getNotasList().isEmpty()){
                    Utilidad.mostrarMensajes("Notas: ");
                    StringJoiner notas = new StringJoiner(", ", "[", "]");
                    for (Double nota : materia.getNotasList()) {
                        notas.add(String.valueOf(nota));
                    }
                    Utilidad.mostrarMensajes(String.valueOf(notas));
                }



            }
        }
    }

    public Alumno buscarAlumno(){
        String stringAlumno = "";
        Alumno alumno = null;
        do {
            Utilidad.mostrarMensajes("Ingresa rut del Alumno: ");
            stringAlumno = lectura.nextLine();
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
        Utilidad.mostrarMensajes("Alumno tiene las siguientes materias agregadas: ");
        int opcion = 1;
        for (Materia materiaUnico : alumno.getMateriaList()) {
            Utilidad.mostrarMensajes(opcion+ "." + materiaUnico.getNombre().name());
            opcion++;
        }
        Utilidad.mostrarMensajes("Salir: 9.");
        int op;
        do {
            op = lectura.nextInt();

            if (op == 9) {
                break;
            }
            if (op > 0 && op <= MateriaEnum.values().length) {
                materia = alumno.getMateriaList().get(op-1);
                Double nota = 0.0;
                do {
                    Utilidad.mostrarMensajes("Ingresar nota (de 1 a 7): ");
                    nota = lectura.nextDouble();
                    if (nota>7 ||nota<1){
                        Utilidad.mostrarMensajes("Nota invalida, ingrese nuevamente.");
                    }
                }while (nota>7 ||nota<1);
                materia.getNotasList().add(nota);
                Utilidad.mostrarMensajesTitulos("¡Nota agregada a "+ materia.getNombre().name()+ "!");
                return;
            } else {
                Utilidad.mostrarMensajes("Opción no válida. Seleccione un número entre 1 y " + MateriaEnum.values().length);
            }
        }while (op != 9);
    }

}
