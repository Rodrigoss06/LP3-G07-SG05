package Ejercicio01.app;

import javax.swing.SwingUtilities;

import Ejercicio01.controllers.ProductController;
import Ejercicio01.models.Producto;
import Ejercicio01.views.MainFrame;


public class App {
    public static void main(String[] args) {
        // Crear el modelo y controlador
        Producto producto = new Producto("Producto Inicial", 0.0, 0, "Sin Categoría");
        ProductController controller = new ProductController(producto);

        // Crear y mostrar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(controller);
            mainFrame.setVisible(true);
        });
    }
}
