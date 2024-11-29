package ejercicio02;

public class DescuentoPorcentual implements Descuento {

    @Override
    public double calcularDescuento(Producto producto) {
        if (producto.getCantidad() >= 2) {
            return producto.getPrecio() * 0.70; // 30% de descuento si hay 2 productos
        }
        return producto.getPrecio();
    }
}

