package ejercicios.ejercicio02;

public class Principal {
    public static void main(String[] args) {
        Forma circulo = new Circulo();
        Forma rectangulo = new Rectangulo();
        Forma triangulo = new Triangulo();

        circulo.dibujar();
        rectangulo.dibujar();
        triangulo.dibujar();
    }
}

