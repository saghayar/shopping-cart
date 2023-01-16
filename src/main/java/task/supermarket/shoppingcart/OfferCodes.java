package task.supermarket.shoppingcart;

public enum OfferCodes {
    BUY_2_GET_1_FREE(3),
    BUY_1_GET_HALF_OFF(2); //2

    private final int value;

    OfferCodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
