package Ejercicio02.views;

import Ejercicio02.controllers.GraphController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField[] temperatureFields;
    private JPanel graphPanel;
    private GraphController controller;

    public MainFrame(GraphController controller) {
        this.controller = controller;

        setTitle("Registro de Temperatura Semanal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 7, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Ingrese las temperaturas"));

        String[] days = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        temperatureFields = new JTextField[7];
        for (int i = 0; i < days.length; i++) {
            inputPanel.add(new JLabel(days[i], SwingConstants.CENTER));
            temperatureFields[i] = new JTextField();
            inputPanel.add(temperatureFields[i]);
        }

        add(inputPanel, BorderLayout.NORTH);

        // Panel del gráfico
        graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                controller.drawGraph((Graphics2D) g, getWidth(), getHeight());
            }
        };
        graphPanel.setBackground(Color.WHITE);
        graphPanel.setBorder(BorderFactory.createTitledBorder("Gráfico de Temperaturas"));
        add(graphPanel, BorderLayout.CENTER);

        // Botón para mostrar el gráfico
        JButton btnShowGraph = new JButton("Mostrar Gráfico");
        btnShowGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] temperatures = new double[7];
                try {
                    for (int i = 0; i < temperatureFields.length; i++) {
                        temperatures[i] = Double.parseDouble(temperatureFields[i].getText());
                    }
                    controller.updateTemperatures(temperatures);
                    graphPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnShowGraph, BorderLayout.SOUTH);
    }
}
