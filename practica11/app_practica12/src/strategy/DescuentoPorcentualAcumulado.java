package strategy;

import java.util.List;

public class DescuentoPorcentualAcumulado implements Descuento {

    @Override
    public double calcularDescuento(Producto producto) {
        // Suponiendo que se aplica un descuento del 50% en el producto más barato si hay 3 o más productos
        if (producto.getCantidad() >= 3) {
            return producto.getPrecio() * 0.50;  // 50% de descuento sobre el precio más bajo
        }
        return producto.getPrecio();
    }
}
