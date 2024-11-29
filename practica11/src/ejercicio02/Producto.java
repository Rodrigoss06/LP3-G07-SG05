package ejercicio02;

import java.util.List;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private List<Producto> productos;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

