package ejercicios;

public class ejercicio03 {

	public static void main(String[] args) {
		Random random = new Random();
		int[] frecuenciaDado = new int[6];
		
		for(int i = 0; i<20000;i++) {
			int resultadoDado = random.nextInt(6);
			frecuenciaDado[resultadoDado]++;
		}
		
		for (int i = 0; i < frecuenciaDado.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuenciaDado[i] + " veces");
        }

	}


}
