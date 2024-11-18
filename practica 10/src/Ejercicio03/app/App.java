package Ejercicio03.app;

import Ejercicio03.controllers.SoundController;
import Ejercicio03.views.MainFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String soundDirectory = "src/sounds/"; // Directorio donde se almacenan los archivos WAV
            SoundController soundController = new SoundController(soundDirectory);
            MainFrame mainFrame = new MainFrame(soundController);
            mainFrame.setVisible(true);
        });
    }
}
