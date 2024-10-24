package ejercicio03;
import ejercicio03.controller.ControladorEmpleado;
import ejercicio03.view.VistaConsola;

public class App {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorEmpleado controlador = new ControladorEmpleado(vista);
        controlador.ejecutar();
    }
}
