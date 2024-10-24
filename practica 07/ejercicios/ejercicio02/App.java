package ejercicio02;

import ejercicio02.controller.ControladorGestor;
import ejercicio02.view.VistaConsola;

public class App {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorGestor controlador = new ControladorGestor(vista);
        controlador.iniciar();
    }
}

