package ejercicios.ejercicio02;

import ejercicios.ejercicio01.Par;

public class PruebaPar {
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Hola", 123);
        Par<String, Integer> par2 = new Par<>("Hola", 123);
        Par<String, Integer> par3 = new Par<>("Adiós", 456);

        System.out.println("¿Par1 es igual a Par2? " + par1.esIgual(par2));  // true
        System.out.println("¿Par1 es igual a Par3? " + par1.esIgual(par3));  // false
    }
}
