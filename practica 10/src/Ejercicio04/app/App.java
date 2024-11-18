package Ejercicio04.app;

import Ejercicio04.controllers.MusicController;
import Ejercicio04.views.MainFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String soundFile = "src/sounds/explosion.wav"; // Ruta del archivo de audio
            MusicController musicController = new MusicController(soundFile);
            MainFrame mainFrame = new MainFrame(musicController);
            mainFrame.setVisible(true);
        });
    }
}
