package ejercicio04.view;

import java.io.File;
import java.util.Map;

import javax.swing.JFileChooser;

public class VistaConsola {

    public File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarFrecuencias(Map<String, Integer> frecuencias) {
        System.out.println("Palabras más frecuentes:");
        frecuencias.forEach((palabra, frecuencia) -> {
            System.out.println(palabra + ": " + frecuencia);
        });
    }
}
