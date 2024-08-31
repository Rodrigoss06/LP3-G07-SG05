package ejercicios;

public class ejercicio01 {

	public static int sumaElementos(int[] arreglo) {
        int suma = 0;
        for (int num : arreglo) {
            suma += num;
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};
        int resultado = sumaElementos(arreglo);
        System.out.println("Suma: " + resultado);
    }

}
