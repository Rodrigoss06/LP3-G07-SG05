package Ejercicio04.controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicController {
    private Clip clip;
    private long pausePosition = 0; // Almacena la posición al pausar
    private final String soundPath;

    public MusicController(String soundPath) {
        this.soundPath = soundPath;
        loadClip();
    }

    /**
     * Carga el archivo de audio en el clip.
     */
    private void loadClip() {
        try {
            File audioFile = new File(soundPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error al cargar el audio: " + e.getMessage());
        }
    }

    /**
     * Reproduce el audio desde el inicio.
     */
    public void play() {
        if (clip != null) {
            pausePosition = 0; // Reinicia la posición al inicio
            clip.setMicrosecondPosition(0);
            clip.start();
        }
    }

    /**
     * Pausa la reproducción del audio.
     */
    public void pause() {
        if (clip != null && clip.isRunning()) {
            pausePosition = clip.getMicrosecondPosition(); // Almacena la posición actual
            clip.stop();
        }
    }

    /**
     * Reanuda la reproducción desde la posición pausada.
     */
    public void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausePosition); // Reanuda desde la posición almacenada
            clip.start();
        }
    }
}

