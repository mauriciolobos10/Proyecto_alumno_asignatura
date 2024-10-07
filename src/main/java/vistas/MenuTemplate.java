package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    public final Scanner lectura = new Scanner(System.in);

    public abstract void exportarDatos();
    public abstract void crearAlummno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlummnos() ;
    public abstract void terminarPrograma();

    public final void iniciarMenu(){
        Integer op = 0;

        System.out.println("MENU PRINCIPAL");
        System.out.println("Digite su opci�n: ");
        op = lectura.nextInt();
        lectura.nextLine();
    }
}
