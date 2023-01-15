package task.supermarket.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {

    private final List<InventoryItem> items = new ArrayList<>();

    public void addItem(InventoryItem item) {
        this.items.add(item);
    }

    public List<InventoryItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
