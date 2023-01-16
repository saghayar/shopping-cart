package task.supermarket.shoppingcart;

import task.supermarket.inventory.Inventory;
import task.supermarket.inventory.InventoryItem;

import java.math.BigDecimal;
import java.util.Locale;

import static java.lang.String.format;
import static task.supermarket.shoppingcart.Messages.BILL;
import static task.supermarket.shoppingcart.Messages.DONE;
import static task.supermarket.shoppingcart.Messages.EMPTY_CARD;
import static task.supermarket.shoppingcart.Messages.INVALID_COMMAND;
import static task.supermarket.shoppingcart.Messages.ITEM_ADDED;
import static task.supermarket.shoppingcart.Messages.NO_PRODUCT_EXIST;
import static task.supermarket.shoppingcart.Messages.OFFER_ADDED;

public class ShoppingService {
    private final ShoppingCart shoppingCart;
    private final Inventory inventory;

    public ShoppingService(ShoppingCart shoppingCart, Inventory inventory) {
        this.shoppingCart = shoppingCart;
        this.inventory = inventory;
    }

    public void doShopping(String input) {
        String[] commands = input.split(" ");
        Commands command = Commands.valueOf(commands[0].toUpperCase(Locale.ROOT));

        switch (command) {
            case ADD:
                String itemName = commands[1];
                String quantity = commands[2];
                if (!inventory.isValidProduct(itemName)) {
                    print(format(NO_PRODUCT_EXIST, itemName));
                    break;
                }
                InventoryItem inventoryItem = inventory.getItemByName(itemName);
                CartItem cartItem = new Product(itemName, inventoryItem.getPrice());
                shoppingCart.addItem(cartItem, Integer.parseInt(quantity));
                print(format(ITEM_ADDED, itemName, quantity));
                break;
            case BILL:
                BigDecimal subtotal = shoppingCart.calculateSubtotal();
                BigDecimal discount = shoppingCart.calculateDiscount();
                print(format(BILL, subtotal, discount, subtotal.subtract(discount)));
                break;
            case OFFER:
                String offerCode = commands[1].toUpperCase(Locale.ROOT);
                String name = commands[2];
                OfferStrategy offerStrategy = OfferStrategy.valueOf(offerCode);
                shoppingCart.getOffers().put(name, offerStrategy);
                print(OFFER_ADDED);
                break;
            case CHECKOUT:
                if (shoppingCart.getItems().isEmpty()) {
                    print(EMPTY_CARD);
                } else {
                    print(DONE);
                    exit();
                }
                break;
            default:
                print(INVALID_COMMAND);
                break;
        }
    }

    private void print(String message) {
        System.out.println(message);
    }


    private void exit() {
        System.exit(0);
    }
}
