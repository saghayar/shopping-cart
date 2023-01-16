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

    @Test
    void calculateSubtotalTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product("apple", BigDecimal.valueOf(4.52397));
        Product orange = new Product("orange", BigDecimal.valueOf(8));

        //Act
        shoppingCart.addItem(apple, 10);
        shoppingCart.addItem(orange, 5);

        //Assert
        BigDecimal subtotal = shoppingCart.calculateSubtotal();

        Assertions.assertEquals(BigDecimal.valueOf(85.24), subtotal);
    }

    @Test
    void shoppingCardCheckoutItemTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Product apple = new Product("apple", BigDecimal.valueOf(12));
        Product onion = new Product("onion", BigDecimal.valueOf(1));

        //Act
        shoppingCart.addItem(apple, 10);
        shoppingCart.addItem(onion, 5);
        shoppingCart.checkout();

    }

    @Test
    void calculateDiscountTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Product pen = new Product("pen", BigDecimal.valueOf(4.5));
        Product soap = new Product("soap", BigDecimal.valueOf(8));
        shoppingCart.addItem(pen, 10);
        shoppingCart.addItem(soap, 5);

        Offer buyTwoGetOneFree = new BuyTwoGetOneFreeOffer();
        buyTwoGetOneFree.apply(shoppingCart, pen.getName());

        //Act
        BigDecimal result = shoppingCart.calculateDiscount();

        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(13.5), result);
    }
}
