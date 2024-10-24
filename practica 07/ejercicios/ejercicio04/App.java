package ejercicio04;
import ejercicio04.controller.ControladorContador;
import ejercicio04.view.VistaConsola;

public class App {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorContador controlador = new ControladorContador(vista);
        controlador.iniciar();
    }
}

