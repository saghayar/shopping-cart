package task.supermarket.shoppingcart;

import task.supermarket.inventory.Inventory;

import java.util.Locale;

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

    }
}
