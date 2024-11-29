package strategy;

public class DescuentoFijo implements Descuento {

    @Override
    public double calcularDescuento(Producto producto) {
        return producto.getPrecio() * 0.90;
    }
}

