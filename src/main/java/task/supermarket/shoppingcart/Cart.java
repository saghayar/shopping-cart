package task.supermarket.shoppingcart;

import java.util.Map;

interface Cart {
    Map<CartItem, Integer> getItems();
    Map<String, OfferStrategy> getOffers();
}
