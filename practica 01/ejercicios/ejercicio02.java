package ejercicios;

public class ejercicio02 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		Scanner entrada = new Scanner(System.in);
		for(int i=0; i<arr.length;i++) {
			int num = -1;
			while(num<(i==0 ?0:arr[i-1])) {
				System.out.println("Ingrese un número mayor que el anterior("+ (i==0 ?0:arr[i-1])+"): ");
				num = entrada.nextInt();
			}
			arr[i] = num;	
		}
		
		System.out.print("Contenido del arreglo: ");
		for (int i = 0; i < arr.length; i++) {
		    System.out.print(arr[i] + " ");
		}

		entrada.close();
		
	}

}
