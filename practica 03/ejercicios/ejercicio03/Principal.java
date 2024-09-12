package ejercicios.ejercicio03;

public class Principal {
    public static void main(String[] args) {
        Vehiculo coche = new Coche("Toyota");
        Vehiculo bicicleta = new Bicicleta("Mountain Bike");

        coche.acelerar();    
        bicicleta.acelerar();  
    }
}
