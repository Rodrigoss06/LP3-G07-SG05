package ejercicios.ejercicio03;

public class Coche extends Vehiculo {
    public Coche(String nombre) {
        super(nombre);
    }

    @Override
    public void acelerar() {
        System.out.println(nombre + " está acelerando con el motor.");
    }
}

