	package ejercicio02;
	
	public class SinDescuento implements Descuento {
	
	    @Override
	    public double calcularDescuento(Producto producto) {
	        return producto.getPrecio(); // No se aplica descuento
	    }
	}
	
