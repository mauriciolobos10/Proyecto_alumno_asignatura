package utilidades;

import java.util.Scanner;

public interface Utilidad {

    public static final Scanner lectura = new Scanner(System.in);
    public static void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void mostrarMensajes(String mensaje){
        System.out.println(mensaje);
    }
    public static void mostrarMensajesTitulos(String mensaje){
        Utilidad.mostrarMensajes("--- " + mensaje + " ---");
    }

    public static void presioneTeclaParaContinuar(){
        Utilidad.mostrarMensajes("Ingrese cualquier tecla para continuar...");
        lectura.nextInt();
        lectura.nextLine();
    }
}
