package ejercicio01;

import ejercicio01.controller.ControladorGestor;
import ejercicio01.view.VistaConsola;

public class App {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorGestor controlador = new ControladorGestor(vista);
        controlador.iniciar();
    }
}
