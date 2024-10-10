package view;

import model.Jugador;
import model.Enemigo;

public class CombateView {

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\nEstado del combate:");
        System.out.println("Jugador: " + jugador.getNombre() + " - Salud: " + jugador.getSalud());
        System.out.println("Enemigo: " + enemigo.getNombre() + " - Salud: " + enemigo.getSalud());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
