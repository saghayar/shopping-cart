package task.supermarket.shoppingcart;

public class BuyTwoGetOneFreeOffer implements Offer {

    @Override
    public void apply(Cart cart, String name) {
        cart.getOffers().put(name, OfferCodes.BUY_2_GET_1_FREE);
    }
}
