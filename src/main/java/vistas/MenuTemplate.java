package vistas;

import utilidades.Utilidad;

import java.util.Scanner;

public abstract class MenuTemplate {
    public final Scanner lectura = new Scanner(System.in);

    public abstract void exportarDatos();
    public abstract void crearAlummno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos() ;
    public abstract void terminarPrograma();

    public final void iniciarMenu(){
        Integer op = 0;
        do {
            Utilidad.limpiarPantalla();
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Crear Alumnos\n" +
                    "2. Listar Alumnos\n" +
                    "3. Agregar Materias\n" +
                    "4. Agregar Notas\n" +
                    "5. Salir\n" +
                    "6. exportarDatos");
            System.out.print("Selección: ");
            op = lectura.nextInt();
            lectura.nextLine();
            switch (op) {
                case 1:
                    crearAlummno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    agregarMateria();
                    break;
                case 4:
                    agregarNotaPasoUno();
                    break;
                case 5:
                    terminarPrograma();
                    break;
                case 6:
                    exportarDatos();
                    break;
                default:
                    System.out.println("Opci�n inv�lida, saliendo de la aplicaci�n.");
                    break;
            }
        }while (op != 5);

    }
}
