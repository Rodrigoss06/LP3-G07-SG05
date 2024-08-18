package ejercicios;

public class ejercicio05 {

	public static double estacionamientoPrecioPorHora(int hora) {

		if (hora == 1) {
			return 3;
		} else if (hora >=18) {
			return 12;
		} else {
			return 3 + (hora-1)*0.5;
		}
	}
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el número de horas en el estacionamiento: ");
        int horas = entrada.nextInt();

        double cargo = estacionamientoPrecioPorHora(horas);
        System.out.println("El cargo por " + horas + " horas es: S/" + cargo);

        entrada.close();

	}


}
