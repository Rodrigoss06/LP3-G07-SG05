package app;

import services.ItemService;

import java.util.Scanner;

import models.Item;

public class MainApp {
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         ItemService itemService = new ItemService();

         itemService.createTable();

         while (true) {
             System.out.println("\nSeleccione una opción:");
             System.out.println("1. Ingresar item");
             System.out.println("2. Borrar item");
             System.out.println("3. Actualizar item");
             System.out.println("4. Mostrar items");
             System.out.println("5. Salir");
             int option = scanner.nextInt();
             scanner.nextLine();

             switch (option) {
                 case 1 -> {
                     System.out.print("Nombre: ");
                     String name = scanner.nextLine();
                     System.out.print("Descripción: ");
                     String description = scanner.nextLine();
                     System.out.print("Precio: ");
                     double price = scanner.nextDouble();
                     scanner.nextLine();
                     System.out.print("Ingrese la clave para confirmar: ");
                     String key = scanner.nextLine();
                     itemService.insertItem(new Item(0, name, description, price), key);
                 }
                 case 2 -> {
                     System.out.print("ID del item a borrar: ");
                     int id = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Ingrese la clave para confirmar: ");
                     String key = scanner.nextLine();
                     itemService.deleteItem(id, key);
                 }
                 case 3 -> {
                     System.out.print("ID del item a actualizar: ");
                     int id = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Nuevo nombre: ");
                     String name = scanner.nextLine();
                     System.out.print("Nueva descripción: ");
                     String description = scanner.nextLine();
                     System.out.print("Nuevo precio: ");
                     double price = scanner.nextDouble();
                     scanner.nextLine();
                     System.out.print("Ingrese la clave para confirmar: ");
                     String key = scanner.nextLine();
                     itemService.updateItem(new Item(id, name, description, price), key);
                 }
                 case 4 -> itemService.displayItems();
                 case 5 -> {
                     System.out.println("Saliendo del programa.");
                     return;
                 }
                 default -> System.out.println("Opción no válida.");
             }
         }
    }
}

