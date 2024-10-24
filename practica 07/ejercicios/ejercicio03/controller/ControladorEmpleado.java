package ejercicio03.controller;


import ejercicio03.model.ArchivoEmpleado;
import ejercicio03.model.Empleado;
import ejercicio03.view.VistaConsola;

import java.util.List;

public class ControladorEmpleado {
    private VistaConsola vista;
    private ArchivoEmpleado archivo;

    public ControladorEmpleado(VistaConsola vista) {
        this.vista = vista;
        this.archivo = new ArchivoEmpleado();
    }

    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    salir = true;
                    vista.mostrarMensaje("Saliendo del programa.");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
        vista.cerrar();
    }

    private void listarEmpleados() {
        List<Empleado> empleados = archivo.leerEmpleados();
        if (empleados.isEmpty()) {
            vista.mostrarMensaje("No hay empleados registrados.");
        } else {
            empleados.forEach(vista::mostrarEmpleado);
        }
    }

    private void agregarEmpleado() {
        Empleado empleado = vista.obtenerDatosEmpleado();
        archivo.agregarEmpleado(empleado);
        vista.mostrarMensaje("Empleado agregado exitosamente.");
    }

    private void buscarEmpleado() {
        int numero = vista.obtenerNumeroEmpleado();
        Empleado empleado = archivo.buscarEmpleado(numero);
        vista.mostrarEmpleado(empleado);
    }

    private void eliminarEmpleado() {
        int numero = vista.obtenerNumeroEmpleado();
        boolean eliminado = archivo.eliminarEmpleado(numero);
        if (eliminado) {
            vista.mostrarMensaje("Empleado eliminado exitosamente.");
        } else {
            vista.mostrarMensaje("No se encontró el empleado con el número proporcionado.");
        }
    }
}

