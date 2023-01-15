package task.supermarket.inventory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class InventoryTest {

    @Test
    void addInventoryItem() {
        //Arrange
        InventoryItem bread = new InventoryItem("bread", BigDecimal.valueOf(2.5), 4);
        InventoryItem soap = new InventoryItem("soap", BigDecimal.valueOf(10), 5);

        //Act
        Inventory inventory = new Inventory();
        inventory.addItem(bread);
        inventory.addItem(soap);

        List<InventoryItem> items = inventory.getItems();

        //Assert
        Assertions.assertEquals(2, items.size());

        boolean soapAdded = items.stream().anyMatch(it -> it.getName().equals("soap"));
        Assertions.assertTrue(soapAdded);
    }
}
