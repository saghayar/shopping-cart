package task.supermarket.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OfferTest {

    @Test
    void buyTwoGetOneOfferTest() {
        //Arrange
        ShoppingCart shoppingCart = new ShoppingCart();
        Product salt = new Product("salt", BigDecimal.valueOf(2));

        //Act
        shoppingCart.addItem(salt, 10);

        Offer offer = new BuyTwoGetOneOffer();
        offer.apply(shoppingCart, "salt");

        //Assert

    }
}
