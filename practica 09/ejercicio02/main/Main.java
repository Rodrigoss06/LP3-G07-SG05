	package Ejercicio02.main;
	
	import Ejercicio02.controller.ControladorCompra;
	import Ejercicio02.model.Pasajero;
	import Ejercicio02.view.VentanaCompraPasaje;
	
	public class Main {
	    public static void main(String[] args) {
	        Pasajero pasajero = new Pasajero();
	        VentanaCompraPasaje vista = new VentanaCompraPasaje();
	        ControladorCompra controlador = new ControladorCompra(pasajero, vista);
	
	        vista.setVisible(true);
	    }
	}
