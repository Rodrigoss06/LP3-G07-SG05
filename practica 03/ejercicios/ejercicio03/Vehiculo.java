package ejercicios.ejercicio03;

public abstract class Vehiculo implements Acelerable {
    protected String nombre;

    public Vehiculo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

