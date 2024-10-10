package controller;

import model.InventarioModel;
import model.Item;
import view.InventarioView;

import java.util.List;

public class InventarioController {
    private InventarioModel model;
    private InventarioView view;

    public InventarioController(InventarioModel model, InventarioView view) {
        this.model = model;
        this.view = view;
    }

    public void agregarItem(Item item) {
        model.agregarItem(item);
        view.mostrarMensaje(item.getNombre() + " ha sido agregado al inventario.");
    }

    public void eliminarItem(Item item) {
        if (model.buscarItem(item.getNombre()) != null) {
            model.eliminarItem(item);
            view.mostrarMensaje(item.getNombre() + " ha sido eliminado del inventario.");
        } else {
            view.mostrarMensaje("El ítem no existe en el inventario.");
        }
    }

    public void verInventario() {
        List<Item> items = model.obtenerItems();
        view.mostrarInventario(items);
    }

    public void mostrarDetalles(Item item) {
        view.mostrarDetalleItem(item);
    }

    public void buscarItem(String nombre) {
        Item item = model.buscarItem(nombre);
        view.mostrarDetalleItem(item);
    }
}
