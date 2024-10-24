package ejercicio02.controller;

import ejercicio02.model.Gestor;
import ejercicio02.model.Personaje;
import ejercicio02.view.VistaConsola;

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
                    actualizarAtributoIndividual();
                    break;
                case 4:
                    eliminarPersonaje();
                    break;
                case 5:
                    gestor.mostrarPersonajes();
                    break;
                case 6:
                    filtrarPersonajes();
                    break;
                case 7:
                    gestor.mostrarEstadisticas();
                    break;
                case 8:
                    subirNivel();
                    break;
                case 9:
                    importarPersonajes();
                    break;
                case 10:
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
        int nivel = vista.obtenerValor("nivel");
        Personaje personaje = new Personaje(nombre, vida, ataque, defensa, alcance, nivel);
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

    private void actualizarAtributoIndividual() {
        String nombre = vista.obtenerNombre();
        String atributo = vista.obtenerAtributo();
        int nuevoValor = vista.obtenerValor("nuevo valor");
        gestor.actualizarAtributoIndividual(nombre, atributo, nuevoValor);
    }

    private void eliminarPersonaje() {
        String nombre = vista.obtenerNombre();
        gestor.eliminarPersonaje(nombre);
    }

    private void filtrarPersonajes() {
        String atributo = vista.obtenerAtributo();
        gestor.filtrarPersonajesPorAtributo(atributo);
    }

    private void subirNivel() {
        String nombre = vista.obtenerNombre();
        gestor.mejorarNivel(nombre);
    }

    private void importarPersonajes() {
        String archivo = vista.obtenerArchivo();
        gestor.importarPersonajesDesdeArchivo(archivo);
    }
}
