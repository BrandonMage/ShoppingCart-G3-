import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {
  
    private static HashMap<Integer, String> products = new HashMap<Integer, String>();
    private static HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();
    private static Scanner scanner = new Scanner(System.in);

      public static void main(String[] args) {
        // Adding products to the products HashMap
        products.put(1, "Product 1");
        products.put(2, "Product 1");
        products.put(3, "Product 3");
        
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

        