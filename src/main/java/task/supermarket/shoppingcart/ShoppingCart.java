package task.supermarket.shoppingcart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Cart {
    private final Map<CartItem, Integer> items = new HashMap<>();

    public void addItem(CartItem item, int quantity) {
        if (!items.containsKey(item))
            items.put(item, quantity);
        else {
            int totalCount = items.get(item) + quantity;
            items.put(item, totalCount);
        }
    }

    public Map<CartItem, Integer> getItems() {
        return items;
    }

    public BigDecimal totalCardValue() {
        return items.entrySet()
                    .stream()
                    .map(ent -> ent.getKey()
                                   .getPrice()
                                   .multiply(BigDecimal.valueOf(ent.getValue()))
                    ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
