package ejercicio01.view;

import java.util.Scanner;

public class VistaConsola {

    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nGestor de Personajes:");
        System.out.println("1. Añadir personaje");
        System.out.println("2. Modificar personaje");
        System.out.println("3. Eliminar personaje");
        System.out.println("4. Mostrar personajes");
        System.out.println("5. Salir");
    }

    public int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String obtenerNombre() {
        System.out.print("Ingrese el nombre del personaje: ");
        return scanner.next();
    }

    public int obtenerValor(String atributo) {
        System.out.print("Ingrese " + atributo + ": ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}

