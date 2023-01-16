package task.supermarket.shoppingcart;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Cart {
    private final Map<CartItem, Integer> items = new HashMap<>();
    private final Map<String, OfferCodes> offers = new HashMap<>();

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

    @Override
    public Map<String, OfferCodes> getOffers() {
        return offers;
    }

    public BigDecimal calculateSubtotal() {
        return items.entrySet()
                    .stream()
                    .map(ent -> ent.getKey()
                                   .getPrice()
                                   .multiply(BigDecimal.valueOf(ent.getValue())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    public void checkout() {

    }
}
