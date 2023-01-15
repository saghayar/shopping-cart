package task.supermarket.inventory;

import java.math.BigDecimal;

public class InventoryItem {

    private final String name;
    private final BigDecimal price;
    private final Integer quantity;

    public InventoryItem(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
