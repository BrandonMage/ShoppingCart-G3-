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

  } 
}