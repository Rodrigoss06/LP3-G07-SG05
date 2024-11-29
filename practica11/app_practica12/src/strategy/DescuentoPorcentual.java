package strategy;

import java.util.List;

public class DescuentoPorcentual implements Descuento {

    @Override
    public double calcularDescuento(Producto producto) {
        // Si hay 2 productos iguales, aplica un 30% de descuento en cada uno.
        if (producto.getCantidad() >= 2) {
            return producto.getPrecio() * 0.70;  // 30% de descuento
        }
        return producto.getPrecio();
    }
}
