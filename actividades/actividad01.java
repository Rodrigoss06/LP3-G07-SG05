package actividades;

import java.util.Scanner;

public class actividad01 {

	public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void imprimirPrimos(int n) {
        System.out.println("Números primos entre 1 y " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (esPrimo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese un número: ");
        int n = entrada.nextInt();
        imprimirPrimos(n);
        entrada.close();
    }

}
