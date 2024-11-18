package Ejercicio03.controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundController {

    private final String soundPath;

    public SoundController(String soundPath) {
        this.soundPath = soundPath;
    }

    /**
     * Reproduce un archivo de sonido.
     *
     * @param soundFile Nombre del archivo de sonido (con extensión .wav)
     */
    public void playSound(String soundFile) {
        try {
            File audioFile = new File(soundPath + soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // Libera los recursos después de la reproducción
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }

    /**
     * Valida si un archivo es un archivo WAV existente.
     *
     * @param soundFile Nombre del archivo de sonido (con extensión .wav)
     * @return true si el archivo es válido, false en caso contrario
     */
    public boolean isValidWavFile(String soundFile) {
        File file = new File(soundPath + soundFile);
        return file.exists() && file.isFile() && soundFile.endsWith(".wav");
    }
}

