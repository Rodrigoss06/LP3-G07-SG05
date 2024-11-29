package Menu;

import command.*;
import strategy.*;
import observer.*;

import java.util.*;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Producto> carrito = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\nSeleccione una acción:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Realizar pedido");
            System.out.println("4. Ver promociones");
            System.out.println("5. Suscribir usuario a notificaciones");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProductoAlCarrito();
                    break;
                case 2:
                    verCarrito();
                    break;
                case 3:
                    realizarPedido();
                    break;
                case 4:
                    verPromociones();
                    break;
                case 5:
                    suscribirUsuario();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar la aplicación!");
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para agregar un producto al carrito
    private static void agregarProductoAlCarrito() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Producto producto = new Producto(nombre, precio, cantidad);
        carrito.add(producto);
        System.out.println("Producto agregado al carrito: " + nombre);
    }

    // Método para ver los productos en el carrito
    private static void verCarrito() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("\nProductos en el carrito:");
            for (Producto producto : carrito) {
                System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
            }
        }
    }

    // Método para realizar un pedido
    private static void realizarPedido() {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. No se puede realizar el pedido.");
            return;
        }

        // Selección de la estrategia de descuento
        System.out.println("\nSeleccione una estrategia de descuento:");
        System.out.println("1. Descuento Fijo (10%)");
        System.out.println("2. Descuento Porcentual (30% en 2 productos iguales)");
        System.out.println("3. Descuento Acumulado (50% en el producto más barato si hay 3 o más productos)");

        int opcionDescuento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Descuento descuento = null;
        switch (opcionDescuento) {
            case 1:
                descuento = new DescuentoFijo();
                break;
            case 2:
                descuento = new DescuentoPorcentual();
                break;
            case 3:
                descuento = new DescuentoPorcentualAcumulado();
                break;
            default:
                System.out.println("Opción de descuento no válida.");
                return;
        }

        // Crear la calculadora con la estrategia de descuento seleccionada
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios(descuento);

        // Crear el comando para realizar el pedido y pasarle la lista de productos y la calculadora de precios
        Command realizarPedido = new RealizarPedidoCommand(carrito, calculadora);
        realizarPedido.ejecutar();
    }

    // Método para mostrar las promociones
    private static void verPromociones() {
        Notificacion notificacion = new Notificacion();
        for (Usuario usuario : usuarios) {
            notificacion.agregar(usuario);  // Notificar a todos los usuarios suscritos
        }
        notificacion.setMensaje("¡Promoción especial de verano! 30% de descuento en productos seleccionados.");
        System.out.println("Se ha enviado una promoción a todos los usuarios suscritos.");
    }

    // Método para suscribir un usuario a las notificaciones
    private static void suscribirUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        Usuario usuario = new Usuario(nombre);
        usuarios.add(usuario);
        System.out.println("Usuario " + nombre + " suscrito a las notificaciones.");
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}
