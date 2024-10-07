package modelos;

import utilidades.Utilidad;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notasList;

    public Materia() {
        setNombre();
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre() {
        Utilidad.mostrarMensajes("Seleccione el nombre de la materia: ");
        int opcion = 1;
        for (MateriaEnum materia : MateriaEnum.values()) {
            Utilidad.mostrarMensajes("Opcion "+opcion+ ":" + materia.name());
            opcion++;
        }
        Utilidad.mostrarMensajes("Salir: 9.");
        int op;
        do {
            op = Utilidad.lectura.nextInt();

            if (op > 0 && op <= MateriaEnum.values().length) {
                this.nombre = MateriaEnum.values()[op - 1];  // Asignar el enum correspondiente
                Utilidad.mostrarMensajes("Materia seleccionada: " + this.nombre.name());
            } else {
                Utilidad.mostrarMensajes("Opción no válida. Seleccione un número entre 1 y " + MateriaEnum.values().length);
            }
        }while (op != 9 || this.nombre != null);

    }

    public List<Double> getNotasList() {
        return notasList;
    }
    public void setNotasList() {
        notasList = new ArrayList<>();
        estara bien?
    }

}
