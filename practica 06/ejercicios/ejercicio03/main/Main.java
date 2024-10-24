package main;
import controller.CombateController;
import controller.InventarioController;
import model.Enemigo;
import model.Item;
import model.Jugador;
import view.CombateView;
import view.InventarioView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear jugador
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreJugador = scanner.nextLine();
        Jugador jugador = new Jugador(nombreJugador, 100, 1); 

        // Crear enemigo
        Enemigo enemigo = new Enemigo("Goblin", 50, 1, "Criatura");

        // Agregar ítems al inventario del jugador
        Item espada = new Item("Espada", 25, "Arma", "Una espada afilada que causa un alto daño"); 
        Item pocion = new Item("Poción de salud", 50, "Poción", "Restaura 50 puntos de salud"); 
        jugador.getInventario().agregarItem(espada);
        jugador.getInventario().agregarItem(pocion);

        jugador.equiparItem(espada);

        InventarioView inventarioView = new InventarioView();
        InventarioController inventarioController = new InventarioController(jugador.getInventario(), inventarioView);

        CombateView combateView = new CombateView();
        CombateController combateController = new CombateController(jugador, enemigo, combateView, inventarioController, scanner); // Se pasa el scanner

        combateController.iniciarCombate();

        scanner.close();
    }
}
