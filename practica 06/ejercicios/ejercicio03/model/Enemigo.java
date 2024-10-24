package model;
import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void recibirDanio(int danio) {
        this.salud -= danio;
        System.out.println(nombre + " ha recibido " + danio + " de daño. Salud restante: " + salud);
    }

    public void atacar(Jugador jugador) {
        Random random = new Random();
        int danio = random.nextInt(nivel * 10); 
        jugador.recibirDanio(danio);
        System.out.println(nombre + " ataca a " + jugador.getNombre() + " causando " + danio + " de daño.");
    }
}
