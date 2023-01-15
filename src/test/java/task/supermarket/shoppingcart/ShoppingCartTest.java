package task.supermarket.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ShoppingCartTest {

    @Test
    void shoppingCardTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Product soap = new Product("soap", BigDecimal.ONE);
        Product bread = new Product("bread", BigDecimal.TEN);
    }
}
