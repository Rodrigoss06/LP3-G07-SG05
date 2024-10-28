package app;

import models.Item;
import services.ItemManager;
import services.ItemService;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mostrando todos los items:");
        List<Item> items = itemService.getAllItems();
        ItemManager itemManager = new ItemManager(items);

        System.out.println("Ingrese el campo para filtrar (name, description, price), o presione Enter para omitir:");
        String conditionField = scanner.nextLine();
        System.out.println("Ingrese el valor de condición o presione Enter para omitir:");
        String conditionValue = scanner.nextLine();

        System.out.println("Ingrese el campo para ordenar (id, name, description, price):");
        String sortField = scanner.nextLine();
        System.out.println("Orden descendente? (true/false):");
        boolean descending = scanner.nextBoolean();
        System.out.println("Cantidad de registros a mostrar:");
        int limit = scanner.nextInt();

        List<Item> filteredItems = itemManager.queryItems(List.of("id", "name", "description", "price"),
                                                          conditionField, conditionValue, sortField, descending, limit);
        filteredItems.forEach(System.out::println);

        itemService.close();
    }
}
