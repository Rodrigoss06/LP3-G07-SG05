package ejercicios.ejercicio04;

public class Impresora implements Imprimible {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo: " + documento);
    }
}
