package task.supermarket.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public enum Inventory {

    INSTANCE;

    private final List<InventoryItem> items = new ArrayList<>();

    public void addItems(InventoryItem... inventoryItems) {
        this.items.addAll(Arrays.asList(inventoryItems));
    }

    public List<InventoryItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public InventoryItem getItemByName(String name) {
        return items.stream().filter(it -> it.getName().equals(name))
                    .findFirst()
                    .orElseThrow(noProductFoundSupplier(name));
    }

    public boolean isValidProduct(String name) {
        return items.stream().anyMatch(it -> it.getName().equals(name));
    }

    private Supplier<RuntimeException> noProductFoundSupplier(String name) {
        return () -> new RuntimeException("No product exist in inventory with name " + name);
    }
}
