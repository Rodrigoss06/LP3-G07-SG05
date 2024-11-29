package ejercicio02;

import java.util.List;

public class DescuentoPorcentualAcumulado implements Descuento {

    @Override
    public double calcularDescuento(Producto producto) {
        if (producto.getCantidad() >= 3) {
            // Descuento del 50% sobre el producto más barato
            double descuento = producto.getProductos().stream()
                .mapToDouble(Producto::getPrecio)
                .min()
                .getAsDouble() * 0.50;
            return producto.getPrecio() - descuento;
        }
        return producto.getPrecio();
    }
}

