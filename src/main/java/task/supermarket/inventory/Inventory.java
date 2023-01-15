package task.supermarket.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Inventory {

    INSTANCE;

    private final List<InventoryItem> items = new ArrayList<>();

    public void addItems(InventoryItem... inventoryItems) {
        this.items.addAll(Arrays.asList(inventoryItems));
    }

    public List<InventoryItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
