package ejercicios.ejercicio04;

public class Principal {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        impresora.imprimir("Documento1.pdf");

        ImpresoraMultifuncional impresoraMultifuncional = new ImpresoraMultifuncional();
        impresoraMultifuncional.imprimir("Documento2.pdf");
        impresoraMultifuncional.escanear("Documento2.pdf");
    }
}
