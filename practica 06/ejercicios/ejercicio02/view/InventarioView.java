package view;

import model.Item;
import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Inventario:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetalleItem(Item item) {
        if (item != null) {
            System.out.println("Detalle del ítem: " + item);
        } else {
            System.out.println("El ítem no existe en el inventario.");
        }
    }
}
