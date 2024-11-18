package Ejercicio01.views;

import Ejercicio01.controllers.ProductController;
import Ejercicio01.models.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField txtNombre, txtPrecio, txtCantidad, txtCategoria;
    private JLabel lblInfo;
    private ProductController controller;

    public MainFrame(ProductController controller) {
        this.controller = controller;

        // Configuración de la ventana principal
        setTitle("Gestión de Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Componentes de la interfaz
        add(new JLabel("Nombre del Producto:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Cantidad en Stock:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        JButton btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);

        lblInfo = new JLabel("Información del producto aparecerá aquí.");
        add(lblInfo);

        // Acción del botón
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    double precio = Double.parseDouble(txtPrecio.getText());
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    String categoria = txtCategoria.getText();

                    controller.actualizarProducto(nombre, precio, cantidad, categoria);
                    lblInfo.setText(controller.obtenerProductoInfo());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
