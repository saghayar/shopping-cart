package task.supermarket.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.supermarket.inventory.Inventory;
import task.supermarket.inventory.InventoryItem;

import java.math.BigDecimal;

class ShoppingServiceTest {

    @Test
    void doShoppingTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Inventory inventory = Inventory.INSTANCE;

        inventory.addItems(new InventoryItem("soap", BigDecimal.TEN, 100));
        inventory.addItems(new InventoryItem("bread", BigDecimal.valueOf(2.50), 100));
        ShoppingService shoppingService = new ShoppingService(shoppingCart, inventory);

        //Act
        shoppingService.doShopping("add soap 5");
        shoppingService.doShopping("add bread 1");

        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(52.50), shoppingCart.calculateSubtotal());
        Assertions.assertEquals(BigDecimal.valueOf(0), shoppingCart.calculateDiscount());

        //Act
        shoppingService.doShopping("offer buy_2_get_1_free soap");

        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(52.50), shoppingCart.calculateSubtotal());
        Assertions.assertEquals(BigDecimal.valueOf(10), shoppingCart.calculateDiscount());


    }
}
