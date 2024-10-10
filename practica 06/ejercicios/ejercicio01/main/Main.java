package main;

import controller.CartController;
import model.Cart;
import model.Product;
import model.PurchaseHistory;
import view.CartView;
import view.ProductView;
import view.PurchaseHistoryView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        PurchaseHistory history = new PurchaseHistory();
        CartView cartView = new CartView();
        ProductView productView = new ProductView();
        PurchaseHistoryView historyView = new PurchaseHistoryView();

        CartController controller = new CartController(cart, history, cartView, productView, historyView);

        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.0, 10),
            new Product("Smartphone", 800.0, 20),
            new Product("Mouse", 25.0, 50),
            new Product("Keyboard", 40.0, 30)
        );

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú principal:");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Añadir producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Eliminar producto del carrito");
            System.out.println("5. Realizar compra");
            System.out.println("6. Ver historial de compras");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.showProducts(products);
                    break;
                case 2:
                    System.out.print("Ingrese el número del producto a añadir al carrito: ");
                    int productIndex = scanner.nextInt() - 1;
                    if (productIndex >= 0 && productIndex < products.size()) {
                        controller.addProductToCart(products.get(productIndex));
                    } else {
                        System.out.println("Producto no válido.");
                    }
                    break;
                case 3:
                    controller.showCart();
                    break;
                case 4:
                    System.out.print("Ingrese el número del producto a eliminar del carrito: ");
                    int removeIndex = scanner.nextInt() - 1;
                    if (removeIndex >= 0 && removeIndex < cart.getProducts().size()) {
                        controller.removeProductFromCart(cart.getProducts().get(removeIndex));
                    } else {
                        System.out.println("Producto no válido.");
                    }
                    break;
                case 5:
                    controller.checkout();
                    break;
                case 6:
                    controller.showPurchaseHistory();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
}
