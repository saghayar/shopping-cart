package task.supermarket.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

class OfferTest {

    @Test
    void buyTwoGetOneOfferTest() {
        //Arrange
        String itemName = "salt";
        ShoppingCart shoppingCart = new ShoppingCart();
        Product salt = new Product(itemName, BigDecimal.valueOf(2));

        //Act
        shoppingCart.addItem(salt, 10);

        Offer offer = new BuyTwoGetOneFreeOffer();
        offer.apply(shoppingCart, itemName);

        //Assert
        Map<String, OfferCodes> offers = shoppingCart.getOffers();
        Assertions.assertSame(OfferCodes.BUY_2_GET_1_FREE, offers.get(itemName));
    }
}
