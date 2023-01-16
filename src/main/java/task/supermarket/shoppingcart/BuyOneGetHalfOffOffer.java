package task.supermarket.shoppingcart;

public class BuyOneGetHalfOffOffer implements Offer {

    @Override
    public void apply(Cart cart, String name) {
        cart.getOffers().put(name, OfferStrategy.BUY_1_GET_HALF_OFF);
    }
}
