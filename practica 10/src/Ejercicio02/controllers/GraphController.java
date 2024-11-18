package Ejercicio02.controllers;


import java.awt.*;

public class GraphController {
    private double[] temperatures;

    public GraphController() {
        // Inicializa las temperaturas con valores por defecto
        temperatures = new double[7];
    }

    public void updateTemperatures(double[] temperatures) {
        this.temperatures = temperatures;
    }

    public void drawGraph(Graphics2D g, int width, int height) {
        if (temperatures == null || temperatures.length < 7) return;

        int padding = 50;
        int graphWidth = width - 2 * padding;
        int graphHeight = height - 2 * padding;

        // Coordenadas base
        int xStart = padding;
        int yStart = height - padding;

        // Días en el eje X
        String[] days = {"L", "M", "X", "J", "V", "S", "D"};

        // Escalado de valores
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        for (double temp : temperatures) {
            maxTemp = Math.max(maxTemp, temp);
            minTemp = Math.min(minTemp, temp);
        }
        double range = maxTemp - minTemp;
        if (range == 0) range = 1;

        // Dibujar ejes
        g.setColor(Color.BLACK);
        g.drawLine(xStart, yStart, xStart + graphWidth, yStart); // Eje X
        g.drawLine(xStart, yStart, xStart, yStart - graphHeight); // Eje Y

        // Dibujar puntos y líneas
        int daySpacing = graphWidth / 6;
        int[] xPoints = new int[7];
        int[] yPoints = new int[7];
        for (int i = 0; i < temperatures.length; i++) {
            int x = xStart + i * daySpacing;
            int y = (int) (yStart - ((temperatures[i] - minTemp) / range) * graphHeight);
            xPoints[i] = x;
            yPoints[i] = y;

            // Dibujar puntos
            g.setColor(Color.BLUE);
            g.fillOval(x - 4, y - 4, 8, 8);

            // Etiquetas de días
            g.setColor(Color.BLACK);
            g.drawString(days[i], x - 5, yStart + 15);
        }

        // Dibujar líneas entre puntos
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(2));
        g.drawPolyline(xPoints, yPoints, temperatures.length);
    }
}
