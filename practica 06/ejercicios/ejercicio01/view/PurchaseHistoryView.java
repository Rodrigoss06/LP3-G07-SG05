package view;

import model.Product;
import java.util.List;

public class PurchaseHistoryView {
    public void displayHistory(List<List<Product>> history) {
        if (history.isEmpty()) {
            System.out.println("No hay compras anteriores.");
        } else {
            System.out.println("Historial de compras:");
            for (List<Product> purchase : history) {
                System.out.println("Compra:");
                for (Product product : purchase) {
                    System.out.println(product);
                }
                System.out.println("------");
            }
        }
    }
}
