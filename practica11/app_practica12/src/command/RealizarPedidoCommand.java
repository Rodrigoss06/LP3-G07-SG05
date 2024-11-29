package command;

import strategy.Producto;
import strategy.CalculadoraDePrecios;

import java.util.List;

public class RealizarPedidoCommand implements Command {
    private List<Producto> carrito;
    private CalculadoraDePrecios calculadora;

    // Constructor recibe la lista de productos (carrito) y la calculadora con la estrategia de descuento
    public RealizarPedidoCommand(List<Producto> carrito, CalculadoraDePrecios calculadora) {
        this.carrito = carrito;
        this.calculadora = calculadora;
    }

    @Override
    public void ejecutar() {
        double precioTotalConDescuento = 0;

        // Iteramos sobre cada producto en el carrito para calcular su precio con descuento
        for (Producto producto : carrito) {
            double precioFinal = calculadora.calcularPrecioFinal(producto);
            precioTotalConDescuento += precioFinal;  // Acumulamos el precio con descuento
            System.out.println(producto.getNombre() + " - Precio final con descuento: $" + precioFinal);
        }

        // Imprimimos el precio total del pedido después de aplicar los descuentos
        System.out.println("\nEl precio total con descuento aplicado es: $" + precioTotalConDescuento);
    }
}
