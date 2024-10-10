package model;

public class Item {
    private String nombre;
    private int efecto;  // Efecto que puede ser daño o curación
    private String tipo;  // Tipo de ítem: "Arma" o "Poción"
    private String descripcion;

    public Item(String nombre, int efecto, String tipo, String descripcion) {
        this.nombre = nombre;
        this.efecto = efecto;  // Daño fijo para armas o cantidad de curación para pociones
        this.tipo = tipo;  // Diferenciar entre arma y poción
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEfecto() {
        return efecto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - " + descripcion + " | Efecto: " + efecto;
    }
}
