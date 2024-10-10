package view;

import model.Item;
import java.util.List;
import java.util.Scanner;

public class InventarioView {

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario del jugador:");
            int i = 1;
            for (Item item : items) {
                System.out.println(i + ". " + item);
                i++;
            }
        }
    }

    public int seleccionarItem(List<Item> items) {
        Scanner scanner = new Scanner(System.in);
        mostrarInventario(items);
        if (items.isEmpty()) {
            return -1;
        } else {
            System.out.print("Seleccione el número del ítem que desea usar/equipar: ");
            int seleccion = scanner.nextInt();
            return seleccion - 1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
