import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {

    private static HashMap<Integer, String> products = new HashMap<Integer, String>();
    private static HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adding products to the products HashMap
        products.put(1, "Apple");
        products.put(2, "Banana");
        products.put(3, "Orange");

        while (true) {
            displayProducts();
            int productNumber = promptForProductNumber();
            if (productNumber == -1) {
                break;
            }
            displayCommands();
            int command = promptForCommand();
            switch (command) {
                case 1:
                    addToCart(productNumber);
                    break;
                case 2:
                    removeFromCart(productNumber);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void displayProducts() {
        for (int i = 1; i <= products.size(); i++) {
            System.out.println(i + ". " + products.get(i));
        }
    }

    // Prompts the user to enter a product number
    private static int promptForProductNumber() {
        System.out.print("Enter the number of the product you want to buy (-1 to exit): ");
        int productNumber = scanner.nextInt();
        if (productNumber < -1 || productNumber > products.size()) {
            System.out.println("Invalid product number.");
            promptForProductNumber();
        }
        return productNumber;
    }

    // Displays the commands
    private static void displayCommands() {
        System.out.println("1. Add to cart");
        System.out.println("2. Remove from cart");
        System.out.println("3. View cart");
        System.out.println("4. Exit");
    }

    // Prompts the user to enter a command
    private static int promptForCommand() {
        System.out.print("Enter the number of the command you want to execute: ");
        int command = scanner.nextInt();
        if (command < 1 || command > 4) {
            System.out.println("Invalid command number.");
            promptForCommand();
        }
        return command;
    }

    //Adding a product to cart
    private static void addToCart(int productNumber) {
        String productName = products.get(productNumber);
        System.out.print("Enter the quantity you want to add: ");
        int quantity = scanner.nextInt();
        if (cart.containsKey(productNumber)) {
            quantity += cart.get(productNumber);
        }
        cart.put(productNumber, quantity);
        System.out.println(quantity + " " + productName + " added to cart.");
    }

    //Removing a product from cart
    private static void removeFromCart(int productNumber) {
        String productName = products.get(productNumber);
        if (!cart.containsKey(productNumber)) {
            System.out.println(productName + " is not in the cart.");
            return;
        }
        int currentQuantity = cart.get(productNumber);
        System.out.print("Enter the quantity you want to remove: ");
        int quantity = scanner.nextInt();
        if (quantity >= currentQuantity) {
            cart.remove(productNumber);
        } else {
            cart.put(productNumber, currentQuantity - quantity);
        }
        System.out.println(quantity + " " + productName + " removed from cart.");
    }

    //Viewing the products on the cart
    private static void viewCart() {
        double totalPrice = 0;
        System.out.println("Cart:");
        for (int productNumber : cart.keySet()) {
            String productName = products.get(productNumber);
            int quantity = cart.get(productNumber);
            double price = quantity * getPrice(productNumber);
            System.out.println(quantity + " " + productName + " - " + formatPrice(price));
            totalPrice += price;
        }
        System.out.println("Total price: " + formatPrice(totalPrice));
        displayCartCommands();
        int command = promptForCartCommand();
        switch (command) {
            case 1:
                displayProducts();
                break;
            case 2:
                checkout(totalPrice);
                break;
            case 3:
                System.exit(0);
        }
    }

    //Getting the prices
    private static double getPrice(int productNumber) {
        double price;
        switch(productNumber) {
            case 1:
                price = 10.99;
                break;
            case 2:
                price = 24.99;
                break;
            case 3:
                price = 7.50;
                break;
            default:
                price = 0.0;
                break;
        }
        return price;
    }
    private static String formatPrice(double price) {
        String formattedPrice = String.format("k%.2f", price);
        return formattedPrice;
    }

    private static void displayCartCommands() {
        System.out.println("1. Continue shopping");
        System.out.println("2. Proceed to checkout");
        System.out.println("3. Exit");
    }

    private static int promptForCartCommand() {
        System.out.print("Enter the number of the command you want to execute: ");
        int command = scanner.nextInt();
        if (command < 1 || command > 3) {
            System.out.println("Invalid command number.");
            promptForCartCommand();
        }
        return command;
    }

    private static void checkout(double totalPrice) {
        System.out.println("Processing...");
        System.out.println("successfully paid " + formatPrice(totalPrice) + ". Thank you!");
        displayCheckoutCommands();
        int command = promptForCheckoutCommand();
        switch (command) {
            case 1:
                main(new String[0]);
                break;
            case 2:
                displayProducts();
                break;
            case 3:
                System.exit(0);     }
    }

    private static void displayCheckoutCommands() {
        System.out.println("1. Continue shopping");
        System.out.println("2. View products");
        System.out.println("3. Exit");
    }

    private static int promptForCheckoutCommand() {
        System.out.print("Enter the number of the command you want to execute: ");
        int command = scanner.nextInt();
        if (command < 1 || command > 3) {
            System.out.println("Invalid command number.");
            promptForCheckoutCommand();
        }
        return command;
    }}

        