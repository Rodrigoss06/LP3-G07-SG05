package ejercicio04.model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ContadorPalabras {

    private File archivo;

    public ContadorPalabras(File archivo) {
        this.archivo = archivo;
    }

    public int contarLineas() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            return (int) br.lines().count();
        }
    }

    public int contarPalabras() throws IOException {
        int totalPalabras = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalPalabras += Arrays.stream(linea.split("\\s+"))
                        .filter(palabra -> palabra.matches("\\w+"))
                        .count();
            }
        }
        return totalPalabras;
    }

    public int contarCaracteres() throws IOException {
        int totalCaracteres = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            int caracter;
            while ((caracter = br.read()) != -1) {
                if (Character.isLetterOrDigit(caracter)) {
                    totalCaracteres++;
                }
            }
        }
        return totalCaracteres;
    }

    public double promedioPalabrasPorLinea() throws IOException {
        int totalPalabras = contarPalabras();
        int totalLineas = contarLineas();
        return totalLineas > 0 ? (double) totalPalabras / totalLineas : 0;
    }

    public Map<String, Integer> palabrasMasFrecuentes() throws IOException {
        Map<String, Integer> frecuencias = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                for (String palabra : linea.split("\\s+")) {
                    if (palabra.matches("\\w+")) {
                        palabra = palabra.toLowerCase();
                        frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }
        return frecuencias.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

