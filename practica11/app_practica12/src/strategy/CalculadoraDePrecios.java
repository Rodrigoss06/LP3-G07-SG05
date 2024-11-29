package strategy;

public class CalculadoraDePrecios {
    private Descuento estrategia;

    public CalculadoraDePrecios(Descuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecioFinal(Producto producto) {
        return estrategia.calcularDescuento(producto);
    }

    public void setEstrategia(Descuento estrategia) {
        this.estrategia = estrategia;
    }
}
