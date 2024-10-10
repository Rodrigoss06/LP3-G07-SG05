package controller;

import model.InventarioModel;
import model.Item;
import view.InventarioView;

public class InventarioController {
    private InventarioModel inventario;
    private InventarioView inventarioView;

    public InventarioController(InventarioModel inventario, InventarioView inventarioView) {
        this.inventario = inventario;
        this.inventarioView = inventarioView;
    }

    public void verInventario() {
        inventarioView.mostrarInventario(inventario.obtenerItems());
    }

    public Item seleccionarItem() {
        int index = inventarioView.seleccionarItem(inventario.obtenerItems());
        if (index >= 0 && index < inventario.obtenerItems().size()) {
            return inventario.obtenerItems().get(index);
        }
        return null;
    }
}
