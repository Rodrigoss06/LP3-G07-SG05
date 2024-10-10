package view;

import model.Product;
import java.util.List;

public class ProductView {
    public void displayProducts(List<Product> products) {
        System.out.println("Productos disponibles:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

