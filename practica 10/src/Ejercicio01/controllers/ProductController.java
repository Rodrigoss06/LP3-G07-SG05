package Ejercicio01.controllers;

import Ejercicio01.models.Producto;

public class ProductController {
    private Producto producto;

    public ProductController(Producto producto) {
        this.producto = producto;
    }

    public void actualizarProducto(String nombre, double precio, int cantidadStock, String categoria) {
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidadStock(cantidadStock);
        producto.setCategoria(categoria);
    }

    public String obtenerProductoInfo() {
        return producto.toString();
    }
}
