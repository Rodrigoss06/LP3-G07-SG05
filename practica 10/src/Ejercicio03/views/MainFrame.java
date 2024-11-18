package Ejercicio03.views;

import Ejercicio03.controllers.SoundController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private SoundController soundController;

    public MainFrame(SoundController controller) {
        this.soundController = controller;

        // Configuración del frame principal
        setTitle("Reproductor de Efectos de Sonido");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Centra la ventana
        getContentPane().setBackground(Color.LIGHT_GRAY); // Fondo de la ventana

        // Título
        JLabel lblTitle = new JLabel("Reproductor de Efectos de Sonido", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Panel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(10, 10));
        inputPanel.setOpaque(false); // Fondo transparente

        JLabel lblInput = new JLabel("Nombre del archivo (sin extensión .wav):");
        lblInput.setFont(new Font("Arial", Font.PLAIN, 14));
        lblInput.setSize(100, 10);
        inputPanel.add(lblInput, BorderLayout.NORTH);

        JTextField txtFileName = new JTextField();
        txtFileName.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(txtFileName, BorderLayout.CENTER);

        JButton btnPlay = createStyledButton("Reproducir", e -> {
            String fileName = txtFileName.getText().trim();
            if (fileName.isEmpty()) {
                showError("Por favor, escribe el nombre del archivo WAV.");
                return;
            }
            String fullFileName = fileName + ".wav";
            if (!soundController.isValidWavFile(fullFileName)) {
                showError("El archivo no existe o no es un archivo WAV válido.");
                return;
            }
            soundController.playSound(fullFileName);
        });

        inputPanel.add(btnPlay, BorderLayout.SOUTH);

        // Margen alrededor del panel de entrada
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Margen
        containerPanel.add(inputPanel, BorderLayout.CENTER);
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

    /**
     * Muestra un cuadro de diálogo con un mensaje de error.
     *
     * @param message Mensaje de error
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
