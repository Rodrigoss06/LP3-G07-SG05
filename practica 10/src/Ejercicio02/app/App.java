package Ejercicio02.app;

import Ejercicio02.controllers.GraphController;
import Ejercicio02.views.*;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphController controller = new GraphController();
            MainFrame frame = new MainFrame(controller);
            frame.setVisible(true);
        });
    }
}

