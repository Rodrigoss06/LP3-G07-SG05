package controller;
import model.Jugador;
import model.Enemigo;
import model.Item;
import view.CombateView;
import java.util.Random;
import java.util.Scanner;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView combateView;
    private InventarioController inventarioController;
    private Scanner scanner;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView combateView, InventarioController inventarioController, Scanner scanner) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.combateView = combateView;
        this.inventarioController = inventarioController;
        this.scanner = scanner;  
    }

    public void iniciarCombate() {
        combateView.mostrarMensaje("¡El combate ha comenzado entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
        Random random = new Random();

        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar ítem del inventario");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    // Jugador ataca al enemigo
                    jugador.atacar(enemigo);
                    combateView.mostrarEstadoCombate(jugador, enemigo);
                    break;
                case 2:
                    // Jugador usa un ítem del inventario
                    Item item = inventarioController.seleccionarItem();
                    if (item != null) {
                        if (item.getTipo().equals("Poción")) {
                            jugador.usarItem(item);  // Curarse
                        } else {
                            combateView.mostrarMensaje("No puedes usar este ítem fuera del combate.");
                        }
                    } else {
                        combateView.mostrarMensaje("No seleccionaste ningún ítem.");
                    }
                    break;
                default:
                    combateView.mostrarMensaje("Opción no válida.");
                    continue;
            }

            if (enemigo.getSalud() <= 0) {
                combateView.mostrarMensaje(enemigo.getNombre() + " ha sido derrotado.");
                break;
            }

            enemigo.atacar(jugador);
            combateView.mostrarEstadoCombate(jugador, enemigo);

            if (jugador.getSalud() <= 0) {
                combateView.mostrarMensaje(jugador.getNombre() + " ha sido derrotado.");
                break;
            }
        }

        combateView.mostrarMensaje("¡El combate ha terminado!");
    }
}
