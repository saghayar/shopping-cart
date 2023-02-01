# shopping-cart

Problem Statement

As a user, I want to be able to add items to a shopping cart so that I can see the total
price. The total price takes into account the quantity of each item as well as offers and
discounts. Items are limited and are stored in an inventory. Item names don’t contain
spaces. For all amounts, round to 2 decimal places using common-rounding .
Inventory
The inventory is a list of available items, the unit price, and their quantities. The initial
values are loaded from a file. The file needs to be specified as an input when running
the program.
Each row should have the following format:
<product_name>,<amount>,<quantity>
Ex.
inventory.csv
soap,10.00,100
bread,2.50,10
Note: You are not expected to update values in the file during runtime.
Offers
Your shopping cart should support the following offers:
1. Buy 2 Get One Free ( buy_2_get_1_free ): When applied to an item, every third
item added is free;
2. Buy 1 Get 50% Off on next ( buy_1_get_half_off ): Every second item is charged
at half the price.
Running the program
The application should allow input in two different ways:
● if only the inventory argument is provided, the application starts an interactive
prompt, where the actions can be typed in;
● if the commands file path is provided as a second argument, such a file is parsed
and the commands in it executed one by one.
In both cases, the commands are separated by a new line. If two offers are applied at
the same product, only the more recent one stands.
Interactive mode
$ ./supermarket inventory.csv
$ checkout
empty cart
$ add soap 5
added soap 5
$ add bread 1
added bread 1
$ bill
subtotal:52.50, discount:0.00, total:52.50
$ offer buy_2_get_1_free soap
offer added
$ bill
subtotal:52.50, discount:10.00, total:42.50
$ add soap 1
added soap 1
$ bill
subtotal:62.50, discount:20.00, total:42.50
$ offer buy_1_get_half_off bread
offer added
$ add bread 1
added bread 1
$ bill
subtotal:65.00, discount:21.25, total:43.75
$ checkout
done
File mode
$ cat commands.txt
checkout
add soap 5
add bread 1
bill
offer buy_2_get_1_free soap
bill
add soap 1
bill
offer buy_1_get_half_off bread
add bread 1
bill
checkout
$ ./supermarket inventory.csv commands.txt
