package task.supermarket.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

class ShoppingCartTest {

    @Test
    void shoppingCardAddItemTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Product soap = new Product("soap", BigDecimal.ONE);
        Product bread = new Product("bread", BigDecimal.TEN);

        //Act
        shoppingCart.addItem(soap, 4);
        shoppingCart.addItem(bread, 2);

        //Assert
        Map<CartItem, Integer> items = shoppingCart.getItems();
        int size = items.values()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum();

        Assertions.assertEquals(6, size);
    }
}
