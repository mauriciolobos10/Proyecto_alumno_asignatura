package servicios;

import modelos.Alumno;
import modelos.Materia;
import utilidades.Utilidad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class ArchivoServicio {
    private List<Alumno> alumnosACargar;
    private PromedioServicioImp promediosServicioImp;

    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        promediosServicioImp = new PromedioServicioImp();
        Utilidad.mostrarMensajesTitulos("Listar Alumnos");
        ruta += "promedios.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            // Se itera sobre el Map de alumnos
            for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
                Utilidad.mostrarMensajes("Datos Alumno");
                String clave = entry.getKey();
                Alumno alumno = entry.getValue();

                writer.write("    Alumno: " + alumno.getRut() + " - " + alumno.getNombre()+" ");

                if (!alumno.getMateriaList().isEmpty()) {
                    for (Materia materia : alumno.getMateriaList()) {
                        String texto = "[materia [nombre=" + materia.getNombre() + ", notas= "+ materia.getNotasList() +"]";
                        writer.write(texto);
                        writer.newLine();
                        writer.write("Materia: "+materia.getNombre()+ " - Promedio: "+promediosServicioImp.calcularPromedio(materia.getNotasList()));
                        writer.newLine();
                    }
                }
            }
            Utilidad.mostrarMensajes("Datos exportados exitosamente a " + ruta);
        } catch (IOException e) {
            Utilidad.mostrarMensajes("Error al exportar los datos: " + e.getMessage());
        }
    }

}
