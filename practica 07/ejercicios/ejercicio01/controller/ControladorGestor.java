package ejercicio01.controller;

import ejercicio01.model.Gestor;
import ejercicio01.model.Personaje;
import ejercicio01.view.VistaConsola;

public class ControladorGestor {

    private VistaConsola vista;
    private Gestor gestor;

    public ControladorGestor(VistaConsola vista) {
        this.vista = vista;
        this.gestor = new Gestor();
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    anadirPersonaje();
                    break;
                case 2:
                    modificarPersonaje();
                    break;
                case 3:
                    eliminarPersonaje();
                    break;
                case 4:
                    gestor.mostrarPersonajes();
                    break;
                case 5:
                    salir = true;
                    vista.mostrarMensaje("Saliendo del programa.");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
        vista.cerrar();
    }

    private void anadirPersonaje() {
        String nombre = vista.obtenerNombre();
        int vida = vista.obtenerValor("vida");
        int ataque = vista.obtenerValor("ataque");
        int defensa = vista.obtenerValor("defensa");
        int alcance = vista.obtenerValor("alcance");
        Personaje personaje = new Personaje(nombre, vida, ataque, defensa, alcance);
        gestor.anadirPersonaje(personaje);
    }

    private void modificarPersonaje() {
        String nombre = vista.obtenerNombre();
        int nuevaVida = vista.obtenerValor("nueva vida");
        int nuevoAtaque = vista.obtenerValor("nuevo ataque");
        int nuevaDefensa = vista.obtenerValor("nueva defensa");
        int nuevoAlcance = vista.obtenerValor("nuevo alcance");
        gestor.modificarPersonaje(nombre, nuevaVida, nuevoAtaque, nuevaDefensa, nuevoAlcance);
    }

    private void eliminarPersonaje() {
        String nombre = vista.obtenerNombre();
        gestor.eliminarPersonaje(nombre);
    }
}

