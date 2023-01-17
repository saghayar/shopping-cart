package task.supermarket;

import task.supermarket.inventory.Inventory;
import task.supermarket.inventory.InventoryItem;
import task.supermarket.shoppingcart.ShoppingCart;
import task.supermarket.shoppingcart.ShoppingService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static task.supermarket.shoppingcart.Messages.SPLIT_BY;

public class Main {

    public static void main(String[] args) throws IOException {
        Inventory inventory = Inventory.INSTANCE;
        final ShoppingCart cart = new ShoppingCart();
        final ShoppingService shoppingService = new ShoppingService(cart, inventory);

        String pathToInventoryFile = parseArgs(args, 0);
        String pathToCommandsFile = parseArgs(args, 1);

        buildInventory(pathToInventoryFile);

        if (pathToCommandsFile != null) {
            proceedToFileMode(shoppingService, pathToCommandsFile);
        } else {
            proceedToInteractiveMode(shoppingService, cart);
        }

    }

    private static String parseArgs(String[] args, int i) {
        return args.length > i ? args[i] : null;
    }

    private static void proceedToFileMode(ShoppingService shoppingService,
                                          String pathToCommandsFile) throws IOException {
        List<String> commands = readLines(pathToCommandsFile);
        commands.forEach(shoppingService::doShopping);
    }

    private static void proceedToInteractiveMode(ShoppingService shoppingService, ShoppingCart cart) {
        do {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            shoppingService.doShopping(input);
        } while (!cart.isCheckedOut());
    }

    private static void buildInventory(String path) throws IOException {
        Inventory inventory = Inventory.INSTANCE;
        List<String> lines = readLines(path);
        lines.forEach(line -> {
            String[] item = line.split(SPLIT_BY);
            inventory.addItems(new InventoryItem(item[0], new BigDecimal(item[1]), Integer.valueOf(item[2])));
        });
    }

    private static List<String> readLines(String path) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.collect(Collectors.toList());
        }
        return result;
    }
}
