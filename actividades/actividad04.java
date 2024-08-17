package actividades;

import java.util.Scanner;

public class actividad04 {

	public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("¿Cuántos números deseas introducir?: ");
        int numElementos = entrada.nextInt();

        int[] numeros = new int[numElementos];

        System.out.println("Introduce los números:");
        for (int i = 0; i < numElementos; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = entrada.nextInt();
        }

        int suma = 0;
        for (int i = 0; i < numElementos; i++) {
            suma += numeros[i];
        }

        double promedio = (double) suma / numElementos;

        System.out.println("El promedio es: " + promedio);

        entrada.close();
    }

}
