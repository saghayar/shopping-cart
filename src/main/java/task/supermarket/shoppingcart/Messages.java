package task.supermarket.shoppingcart;

public class Messages {

    private Messages() {
    }

    public static final String SPLIT_BY = ",";
    public static final String NO_PRODUCT_EXIST = "No product exist in inventory with name %s \n";
    public static final String ITEM_ADDED = "added %s %s";
    public static final String OFFER_ADDED = "offer added";
    public static final String DONE = "done";
    public static final String BILL = "subtotal:%s, discount:%s, total:%s";
    public static final String INVALID_COMMAND = "Invalid command";
    public static final String EMPTY_CARD = "empty cart";
    public static final String MISSING_INVENTORY_FILE = "Inventory file is not provided";
}
