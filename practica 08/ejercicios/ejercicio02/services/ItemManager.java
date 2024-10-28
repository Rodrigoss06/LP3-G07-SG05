package services;

import models.Item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemManager {
    private final List<Item> items;

    public ItemManager(List<Item> items) {
        this.items = items;
    }

    public List<Item> queryItems(List<String> fieldsToShow, String conditionField, String conditionValue, 
                                 String sortField, boolean descending, int limit) {
        return items.stream()
                .filter(item -> {
                    if (conditionField != null && conditionValue != null) {
                        switch (conditionField.toLowerCase()) {
                            case "name":
                                return item.getName().equalsIgnoreCase(conditionValue);
                            case "description":
                                return item.getDescription().equalsIgnoreCase(conditionValue);
                            case "price":
                                return Double.toString(item.getPrice()).equals(conditionValue);
                            default:
                                return true;
                        }
                    }
                    return true;
                })
                .sorted((o1, o2) -> {
                    Comparator<Item> comparator;
                    switch (sortField.toLowerCase()) {
                        case "name":
                            comparator = Comparator.comparing(Item::getName);
                            break;
                        case "description":
                            comparator = Comparator.comparing(Item::getDescription);
                            break;
                        case "price":
                            comparator = Comparator.comparingDouble(Item::getPrice);
                            break;
                        default:
                            comparator = Comparator.comparingInt(Item::getId);
                            break;
                    }
                    return descending ? comparator.reversed().compare(o1, o2) : comparator.compare(o1, o2);
                })
                .limit(limit > 0 ? limit : items.size())
                .collect(Collectors.toList());
    }
}
