package task.supermarket.inventory;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class InventoryItemPojoTest {

    @Test
    void initializeInventoryItem() {
        //Arrange
        InventoryItem item = new InventoryItem("soap", BigDecimal.valueOf(10), 5);

        //Assert
        Assertions.assertEquals(5, item.getQuantity());
    }
}
