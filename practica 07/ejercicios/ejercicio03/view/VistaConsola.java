package ejercicio03.view;

import java.util.Scanner;

import ejercicio03.model.Empleado;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar un empleado por número");
        System.out.println("4. Eliminar un empleado por número");
        System.out.println("5. Salir");
    }

    public int obtenerOpcion() {
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }

    public Empleado obtenerDatosEmpleado() {
        System.out.print("Número del empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Sueldo del empleado: ");
        double sueldo = scanner.nextDouble();
        return new Empleado(numero, nombre, sueldo);
    }

    public int obtenerNumeroEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void cerrar() {
        scanner.close();
    }
}
