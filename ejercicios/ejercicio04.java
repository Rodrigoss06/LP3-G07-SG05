package ejercicios;

public class ejercicio04 {

	public static double minDouble(double num1,double num2,double num3) {
		if (num1<num2 && num1<num3) {
			return num1;
		} else if (num2<num1 && num2<num3) {
			return num2;
		} else {
			return num3;
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el primer número decimal: ");
        double num1 = entrada.nextDouble();
        System.out.print("Ingrese el segundo número decimal: ");
        double num2 = entrada.nextDouble();
        System.out.print("Ingrese el tercer número decimal: ");
        double num3 = entrada.nextDouble();

        double menor = minDouble(num1, num2, num3);
        System.out.println("El menor de los tres números es: " + menor);

        entrada.close();

	}
}
