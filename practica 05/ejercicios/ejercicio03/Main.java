package ejercicios.ejercicio03;

import ejercicios.ejercicio01.Par;

public class Main {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Hola", 123);
        Par<Double, Boolean> par2 = new Par<>(99.99, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Juan", "Perez"), 30);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}

class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}

