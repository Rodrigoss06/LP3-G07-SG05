package controller;

import model.Cart;
import model.Product;
import model.PurchaseHistory;
import view.CartView;
import view.ProductView;
import view.PurchaseHistoryView;

import java.util.List;

public class CartController {
    private Cart cart;
    private PurchaseHistory history;
    private CartView cartView;
    private ProductView productView;
    private PurchaseHistoryView historyView;

    public CartController(Cart cart, PurchaseHistory history, CartView cartView, ProductView productView, PurchaseHistoryView historyView) {
        this.cart = cart;
        this.history = history;
        this.cartView = cartView;
        this.productView = productView;
        this.historyView = historyView;
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
        System.out.println(product.getName() + " ha sido añadido al carrito.");
    }

    public void removeProductFromCart(Product product) {
        cart.removeProduct(product);
        System.out.println(product.getName() + " ha sido eliminado del carrito.");
    }

    public void showProducts(List<Product> products) {
        productView.displayProducts(products);
    }

    public void showCart() {
        cartView.displayCart(cart.getProducts());
        cartView.displayTotal(cart.calculateTotal());
    }

    public void checkout() {
        double total = cart.calculateTotal();
        System.out.println("Compra realizada. Total: $" + total);
        history.addPurchase(cart.getProducts());
        cart.clearCart();
    }

    public void showPurchaseHistory() {
        historyView.displayHistory(history.getHistory());
    }
}
