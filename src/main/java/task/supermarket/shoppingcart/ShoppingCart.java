package task.supermarket.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product item, int quantity) {
        items.put(item, quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double totalCardValue() {
        return 0.0;
    }
}
