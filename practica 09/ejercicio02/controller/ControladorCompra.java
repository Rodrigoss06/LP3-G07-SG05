package Ejercicio02.controller;

import Ejercicio02.model.*;
import Ejercicio02.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCompra {
    private Pasajero pasajero;
    private VentanaCompraPasaje vista;

    public ControladorCompra(Pasajero pasajero, VentanaCompraPasaje vista) {
        this.pasajero = pasajero;
        this.vista = vista;

        // Acción para el botón de resumen
        vista.getBtnResumen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarModelo();
                vista.mostrarResumen(pasajero.toString());
            }
        });

        // Acción para el botón de reiniciar
        vista.getBtnReiniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarFormulario();
            }
        });
    }

    // Actualizar el modelo con los datos de la vista
    private void actualizarModelo() {
        pasajero.setNombre(vista.getTxtNombre().getText());
        pasajero.setDocumento(vista.getTxtDocumento().getText());
        pasajero.setFechaViaje(vista.getTxtFechaViaje().getText());
        pasajero.setAuriculares(vista.getChkAuriculares().isSelected());
        pasajero.setManta(vista.getChkManta().isSelected());
        pasajero.setRevistas(vista.getChkRevistas().isSelected());
        pasajero.setOrigen((String) vista.getCbOrigen().getSelectedItem());
        pasajero.setDestino((String) vista.getCbDestino().getSelectedItem());
        pasajero.setCalidadServicio(vista.getListCalidad().getSelectedValue());
    }

    // Limpiar el formulario
    private void reiniciarFormulario() {
        vista.getTxtNombre().setText("");
        vista.getTxtDocumento().setText("");
        vista.getTxtFechaViaje().setText("");
        vista.getChkAuriculares().setSelected(false);
        vista.getChkManta().setSelected(false);
        vista.getChkRevistas().setSelected(false);
        vista.getRbPrimerPiso().setSelected(false);
        vista.getRbSegundoPiso().setSelected(false);
        vista.getCbOrigen().setSelectedIndex(0);
        vista.getCbDestino().setSelectedIndex(0);
        vista.getListCalidad().clearSelection();
    }
}

