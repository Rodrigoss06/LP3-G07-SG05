package ejercicios.ejercicio03;

public class Principal {
	public abstract class Vehiculo {
	    public abstract void acelerar();
	}

	public class Coche extends Vehiculo {
	    @Override
	    public void acelerar() {
	        System.out.println("El coche está acelerando usando el motor.");
	    }
	}

	public class Bicicleta extends Vehiculo {
	    @Override
	    public void acelerar() {
	        System.out.println("La bicicleta está acelerando pedaleando.");
	    }
	}
}
