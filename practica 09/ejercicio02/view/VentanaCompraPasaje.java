package Ejercicio02.view;

import javax.swing.*;
import java.awt.*;

public class VentanaCompraPasaje extends JFrame {
    // Componentes de la interfaz
    private JTextField txtNombre, txtDocumento, txtFechaViaje;
    private JCheckBox chkAuriculares, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listCalidad;
    private JButton btnReiniciar, btnResumen;

    public VentanaCompraPasaje() {
        setTitle("Compra de Pasaje");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new GridLayout(0, 2));

        // Inicializar componentes
        txtNombre = new JTextField();
        txtDocumento = new JTextField();
        txtFechaViaje = new JTextField();

        chkAuriculares = new JCheckBox("Auriculares");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");

        rbPrimerPiso = new JRadioButton("Primer Piso");
        rbSegundoPiso = new JRadioButton("Segundo Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);

        cbOrigen = new JComboBox<>(new String[]{"Ciudad A", "Ciudad B", "Ciudad C"});
        cbDestino = new JComboBox<>(new String[]{"Ciudad X", "Ciudad Y", "Ciudad Z"});

        listCalidad = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnReiniciar = new JButton("Reiniciar");
        btnResumen = new JButton("Resumen");

        // Añadir componentes al layout
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Documento:"));
        add(txtDocumento);
        add(new JLabel("Fecha de Viaje:"));
        add(txtFechaViaje);

        add(new JLabel("Servicios Opcionales:"));
        add(chkAuriculares);
        add(new JLabel(""));
        add(chkManta);
        add(new JLabel(""));
        add(chkRevistas);

        add(new JLabel("Piso del Asiento:"));
        add(rbPrimerPiso);
        add(new JLabel(""));
        add(rbSegundoPiso);

        add(new JLabel("Origen:"));
        add(cbOrigen);
        add(new JLabel("Destino:"));
        add(cbDestino);

        add(new JLabel("Calidad de Servicio:"));
        add(new JScrollPane(listCalidad));

        add(btnReiniciar);
        add(btnResumen);
    }

    // Getters para los componentes, que serán usados por el controlador
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtDocumento() { return txtDocumento; }
    public JTextField getTxtFechaViaje() { return txtFechaViaje; }
    public JCheckBox getChkAuriculares() { return chkAuriculares; }
    public JCheckBox getChkManta() { return chkManta; }
    public JCheckBox getChkRevistas() { return chkRevistas; }
    public JRadioButton getRbPrimerPiso() { return rbPrimerPiso; }
    public JRadioButton getRbSegundoPiso() { return rbSegundoPiso; }
    public JComboBox<String> getCbOrigen() { return cbOrigen; }
    public JComboBox<String> getCbDestino() { return cbDestino; }
    public JList<String> getListCalidad() { return listCalidad; }
    public JButton getBtnReiniciar() { return btnReiniciar; }
    public JButton getBtnResumen() { return btnResumen; }

    // Método para mostrar el resumen
    public void mostrarResumen(String resumen) {
        JOptionPane.showMessageDialog(this, resumen);
    }
}
