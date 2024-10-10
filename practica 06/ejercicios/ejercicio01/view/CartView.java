package view;

import model.Product;
import java.util.List;

public class CartView {
    public void displayCart(List<Product> cartProducts) {
        if (cartProducts.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Product product : cartProducts) {
                System.out.println(product);
            }
        }
    }

    public void displayTotal(double total) {
        System.out.println("Total del carrito: $" + total);
    }
}

