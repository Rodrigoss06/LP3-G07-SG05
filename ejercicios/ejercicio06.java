package ejercicios;

import java.util.Scanner;

public class ejercicio06 {


	public static int convertirASegundos(int horas,int minutos, int segundos) {
		
		if (horas<0 || minutos<0 || segundos<0) {
			return 0;
		}
		int segundosConversion = 0;
		segundosConversion += horas*3600;
		segundosConversion += minutos*60;
		segundosConversion += segundos;
		
		return segundosConversion;
	}

	public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el número de horas: ");
        int horas = entrada.nextInt();
        System.out.print("Ingrese el número de minutos: ");
        int minutos = entrada.nextInt();
        System.out.print("Ingrese el número de segundos: ");
        int segundos = entrada.nextInt();

        int totalSegundos = convertirASegundos(horas, minutos, segundos);
        System.out.println("El tiempo total en segundos es: " + totalSegundos);

        entrada.close();

	}
}



