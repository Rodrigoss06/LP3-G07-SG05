package command;

import strategy.Producto;

public class AgregarAlCarritoCommand implements Command {
    private Producto producto;

    public AgregarAlCarritoCommand(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        System.out.println("Producto " + producto.getNombre() + " agregado al carrito.");
    }
}
