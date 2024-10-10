package model;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory {
    private List<List<Product>> history;

    public PurchaseHistory() {
        this.history = new ArrayList<>();
    }

    public void addPurchase(List<Product> products) {
        history.add(new ArrayList<>(products));
    }

    public List<List<Product>> getHistory() {
        return history;
    }
}
