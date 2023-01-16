package task.supermarket.shoppingcart;

import org.junit.jupiter.api.Test;
import task.supermarket.inventory.Inventory;
import task.supermarket.inventory.InventoryItem;

import java.math.BigDecimal;

class ShoppingServiceTest {

    @Test
    void doShoppingTest() {
        //Arrange
        Inventory inventory = Inventory.INSTANCE;

        inventory.addItems(new InventoryItem("soap", BigDecimal.TEN, 100));
        inventory.addItems(new InventoryItem("bread", BigDecimal.ONE, 100));

        ShoppingCart shoppingCart = new ShoppingCart();
        Product soap = new Product("soap", BigDecimal.TEN);
        Product bread = new Product("bread", BigDecimal.ONE);

        shoppingCart.addItem(soap, 3);
        shoppingCart.addItem(bread, 5);

        //Act
        ShoppingService shoppingService = new ShoppingService(shoppingCart,inventory);
        shoppingService.doShopping(command);

        //Assert
    }
}
