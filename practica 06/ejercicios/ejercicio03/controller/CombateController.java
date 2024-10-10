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
    private Scanner scanner; // Scanner reutilizable

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView combateView, InventarioController inventarioController, Scanner scanner) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.combateView = combateView;
        this.inventarioController = inventarioController;
        this.scanner = scanner;  // Scanner pasado desde el main para evitar instancias múltiples
    }

    public void iniciarCombate() {
        combateView.mostrarMensaje("¡El combate ha comenzado entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
        Random random = new Random();

        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            // Opción del jugador: Atacar o usar un ítem
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar ítem del inventario");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea pendiente

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
                    continue; // Evitar que el enemigo ataque si el jugador ingresó una opción incorrecta
            }

            // Verificar si el enemigo ha sido derrotado
            if (enemigo.getSalud() <= 0) {
                combateView.mostrarMensaje(enemigo.getNombre() + " ha sido derrotado.");
                break;
            }

            // Turno del enemigo: Ataca al jugador
            enemigo.atacar(jugador);
            combateView.mostrarEstadoCombate(jugador, enemigo);

            // Verificar si el jugador ha sido derrotado
            if (jugador.getSalud() <= 0) {
                combateView.mostrarMensaje(jugador.getNombre() + " ha sido derrotado.");
                break;
            }
        }

        combateView.mostrarMensaje("¡El combate ha terminado!");
    }
}
