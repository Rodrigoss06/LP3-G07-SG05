package actividades;

import java.util.Scanner;

public class actividad03 {

	public static boolean esPerfecto(int numero) {
        int sumaDivisores = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }

        return sumaDivisores == numero;
    }

    public static void imprimirNumerosPerfectos(int n) {
        System.out.println("Números perfectos menores a " + n + ":");
        for (int i = 1; i < n; i++) {
            if (esPerfecto(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese un número:");
        int n = entrada.nextInt();
        imprimirNumerosPerfectos(n);
        entrada.close();
    }

}
