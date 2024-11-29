package ejercicio02;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("Seleccione una estrategia de descuento:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo (10%)");
        System.out.println("3. Descuento porcentual (2 productos iguales 30% descuento)");
        System.out.println("4. Descuento porcentual acumulado (50% descuento sobre el producto más barato a partir de 3 productos)");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Producto producto = new Producto("Producto", 100.0, 2);  // Crear producto de ejemplo
        Producto producto2 = new Producto("Producto2", 50.0, 3); // Crear producto con cantidad 3

        CalculadoraDePrecios calculadora = new CalculadoraDePrecios(new SinDescuento()); // Establecer la estrategia por defecto
        
        switch (opcion) {
            case 1:
                calculadora.setEstrategia(new SinDescuento());
                break;
            case 2:
                calculadora.setEstrategia(new DescuentoFijo());
                break;
            case 3:
                calculadora.setEstrategia(new DescuentoPorcentual());
                break;
            case 4:
                calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        double precioFinal = calculadora.calcularPrecioFinal(producto);
        System.out.println("Precio final del producto: " + precioFinal);
        
        // Mostrar el precio para otro producto
        double precioFinal2 = calculadora.calcularPrecioFinal(producto2);
        System.out.println("Precio final del producto 2: " + precioFinal2);
    }
    public static void main(String[] args) {
        mostrarMenu();
    }
}

