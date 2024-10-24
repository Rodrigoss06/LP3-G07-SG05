package ejercicio02.view;

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
        System.out.println("3. Actualizar un atributo individual");
        System.out.println("4. Eliminar personaje");
        System.out.println("5. Mostrar personajes");
        System.out.println("6. Filtrar personajes por atributo");
        System.out.println("7. Mostrar estadísticas");
        System.out.println("8. Subir nivel a un personaje");
        System.out.println("9. Importar personajes desde archivo");
        System.out.println("10. Salir");
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

    public String obtenerAtributo() {
        System.out.print("Ingrese el atributo (vida, ataque, defensa, alcance): ");
        return scanner.next();
    }

    public String obtenerArchivo() {
        System.out.print("Ingrese el nombre del archivo para importar personajes: ");
        return scanner.next();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
