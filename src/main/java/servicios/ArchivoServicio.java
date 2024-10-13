package servicios;

import modelos.Alumno;
import modelos.Materia;
import utilidades.Utilidad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
    private List<Alumno> alumnosACargar;
    private PromedioServicioImp promediosServicioImp;

    public void exportarDatos(Map<String,Alumno> alumnos, String ruta){
        Utilidad.mostrarMensajesTitulos("Listar Alumnos");
        ruta += "promedios.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            // Se itera sobre el Map de alumnos
            for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
                Utilidad.mostrarMensajes("Datos Alumno");
                String clave = entry.getKey();
                Alumno alumno = entry.getValue();

                writer.write("    RUT: " + alumno.getRut());
                writer.newLine();  // Añade una nueva línea
                writer.write("    Nombre: " + alumno.getNombre());
                writer.newLine();  // Añade una nueva línea
                writer.write("    Apellido: " + alumno.getApellido());
                writer.newLine();  // Añade una nueva línea
                writer.write("    Dirección: " + alumno.getDireccion());
                writer.newLine();  // Añade una nueva línea
                writer.write("    Materias: ");
                writer.newLine();  // Añade una nueva línea
                for (Materia materia : alumno.getMateriaList()) {
                    writer.write("          " + materia.getNombre().name());
                    writer.newLine();  // Añade una nueva línea
                    String notas = "            [";
                    for (Double nota : materia.getNotasList()) {
                        notas = notas + nota + ", ";
                    }
                    // Eliminar la última coma y espacio
                    if (notas.length() > 1) { // Asegurarse de que hay al menos un elemento
                        notas = notas.substring(0, notas.length() - 2); // Elimina los últimos dos caracteres (", ")
                        notas += "]";
                    }
                    writer.write(notas);
                    writer.newLine();  // Añade una nueva línea
                }
            }
            Utilidad.mostrarMensajes("Datos exportados exitosamente a " + ruta);
        } catch (IOException e) {
            Utilidad.mostrarMensajes("Error al exportar los datos: " + e.getMessage());
        }
    }

}
