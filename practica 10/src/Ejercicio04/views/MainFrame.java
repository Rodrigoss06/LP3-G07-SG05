package Ejercicio04.views;


import Ejercicio04.controllers.MusicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private MusicController musicController;

    public MainFrame(MusicController controller) {
        this.musicController = controller;

        // Configuración del frame principal
        setTitle("Reproductor de Música");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Centra la ventana
        getContentPane().setBackground(Color.LIGHT_GRAY); // Fondo de la ventana

        // Título
        JLabel lblTitle = new JLabel("Reproductor de Música", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setOpaque(false);

        // Botones de control
        buttonPanel.add(createStyledButton("Reproducir", e -> musicController.play()));
        buttonPanel.add(createStyledButton("Pausar", e -> musicController.pause()));
        buttonPanel.add(createStyledButton("Reanudar", e -> musicController.resume()));

        // Margen alrededor del panel de botones
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Margen
        containerPanel.add(buttonPanel, BorderLayout.CENTER);
        containerPanel.setOpaque(false); // Fondo transparente

        add(containerPanel, BorderLayout.CENTER);
    }

    /**
     * Crea un botón con estilo redondeado y personalizado.
     *
     * @param text          Texto del botón
     * @param actionListener Acción al presionar el botón
     * @return Botón estilizado
     */
    private JButton createStyledButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false); // Desactiva el borde de enfoque
        button.setBackground(new Color(59, 89, 182)); // Azul
        button.setForeground(Color.WHITE); // Texto blanco
        button.setOpaque(false); // Permitir transparencia para bordes
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Relleno interno
        button.addActionListener(actionListener);

        // Estilización para redondear el botón
        button.setBorderPainted(false);
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(button.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Bordes redondeados
                super.paint(g2, c);
            }
        });

        return button;
    }
}

