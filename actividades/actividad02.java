package actividades;

import java.util.Scanner;

public class actividad02 {

	public static boolean esPalindromo(int numero) {
        int numeroOriginal = numero;
        int numeroInvertido = 0;

        while (numero > 0) {
            int digito = numero % 10;
            numeroInvertido = numeroInvertido * 10 + digito; 
            numero /= 10; 
        }

        return numeroOriginal == numeroInvertido;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese un número: ");
        int numero = entrada.nextInt();
        if (esPalindromo(numero)) {
            System.out.println(numero + " es un palíndromo.");
        } else {
            System.out.println(numero + " no es un palíndromo.");
        }
        
        entrada.close();
    }

}
