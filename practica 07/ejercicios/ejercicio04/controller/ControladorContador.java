package ejercicio04.controller;


import ejercicio04.model.ContadorPalabras;
import ejercicio04.view.VistaConsola;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ControladorContador {

    private VistaConsola vista;

    public ControladorContador(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        File archivo = vista.seleccionarArchivo();
        if (archivo == null) {
            vista.mostrarMensaje("No se seleccionó ningún archivo.");
            return;
        }

        ContadorPalabras contador = new ContadorPalabras(archivo);

        try {
            int totalLineas = contador.contarLineas();
            int totalPalabras = contador.contarPalabras();
            int totalCaracteres = contador.contarCaracteres();
            double promedioPalabras = contador.promedioPalabrasPorLinea();
            Map<String, Integer> frecuencias = contador.palabrasMasFrecuentes();

            vista.mostrarMensaje("Total de líneas: " + totalLineas);
            vista.mostrarMensaje("Total de palabras: " + totalPalabras);
            vista.mostrarMensaje("Total de caracteres (letras y dígitos): " + totalCaracteres);
            vista.mostrarMensaje("Promedio de palabras por línea: " + promedioPalabras);
            vista.mostrarFrecuencias(frecuencias);

        } catch (IOException e) {
            vista.mostrarMensaje("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

