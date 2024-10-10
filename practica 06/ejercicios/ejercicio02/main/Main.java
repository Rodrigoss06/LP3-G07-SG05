package main;

import controller.InventarioController;
import model.InventarioModel;
import model.Item;
import view.InventarioView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioModel model = new InventarioModel();
        InventarioView view = new InventarioView();
        InventarioController controller = new InventarioController(model, view);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú:");
            System.out.println("1. Ver Inventario");
            System.out.println("2. Agregar Ítem");
            System.out.println("3. Eliminar Ítem");
            System.out.println("4. Buscar Ítem");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (choice) {
                case 1:
                    controller.verInventario();
                    break;
                case 2:
                    System.out.print("Nombre del ítem: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Tipo (Arma, Poción, etc.): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    Item item = new Item(nombre, cantidad, tipo, descripcion);
                    controller.agregarItem(item);
                    break;
                case 3:
                    System.out.print("Nombre del ítem a eliminar: ");
                    String eliminarNombre = scanner.nextLine();
                    Item eliminarItem = model.buscarItem(eliminarNombre);
                    controller.eliminarItem(eliminarItem);
                    break;
                case 4:
                    System.out.print("Nombre del ítem a buscar: ");
                    String buscarNombre = scanner.nextLine();
                    controller.buscarItem(buscarNombre);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
