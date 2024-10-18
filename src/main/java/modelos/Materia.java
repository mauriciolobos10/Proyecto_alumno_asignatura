package modelos;

import utilidades.Utilidad;

import javax.swing.plaf.UIResource;
import java.util.ArrayList;
import java.util.List;

public class Materia implements Utilidad {
    private MateriaEnum nombre;
    private List<Double> notasList;

    public Materia() {
        setNombre();
        notasList = new ArrayList<>();
    }
    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre() {
        Utilidad.mostrarMensajes("Selecciona una Materia: ");
        int opcion = 1;
        for (MateriaEnum materia : MateriaEnum.values()) {
            Utilidad.mostrarMensajes("Opcion "+opcion+ ":" + materia.name());
            opcion++;
        }
        Utilidad.mostrarMensajes("Salir: 9.");
        int op;
        do {
            op = lectura.nextInt();

            if(op == 9){
                return;
            }

            if (op > 0 && op <= MateriaEnum.values().length) {
                this.nombre = MateriaEnum.values()[op - 1];  // Asignar el enum correspondiente
//                Utilidad.mostrarMensajes("Materia seleccionada: " + this.nombre.name());
            } else {
                Utilidad.mostrarMensajes("Opción no válida. Seleccione un número entre 1 y " + MateriaEnum.values().length);
            }
        }while (this.nombre == null);

    }

    public List<Double> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Double> notasList) {
        this.notasList = notasList;
    }
}
