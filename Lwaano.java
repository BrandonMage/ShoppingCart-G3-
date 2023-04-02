    private static String formatPrice(double price) {
	  String formattedPrince = string.format("k%.2f", price);
	  return formattedPrice;
    }
    
    private static void displayCartcommands() {
        System.out.println("1. Continue shopping");
	  System.out.println("2. Proceed to checkout");
	  System.out.println("3. Exit");
    }

    private static int promptForCartcommand() {
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
	   System.out.println("succesfully paid " + formatPrice(totalPrice) + ". Thank you!");
         displayCheckoutCommands();
         int command = promptforcheckoutcammand();
         switch (command) {
             case 1:
                 main(new string[0]);
                 break;
             case 2:
                 displayProducts();
                 break;
             case 3:
                 System.exit(0);