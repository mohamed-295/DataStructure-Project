/**
 * Main class to run the Customer Support System.
 * It initializes the system and delegates user interactions
 * to the InputHandler class.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize the customer support system
        CustomerSupportSystem system = new CustomerSupportSystem();

        // Create an InputHandler to manage user interactions
        InputHandler inputHandler = new InputHandler(system);

        // Start the CLI for the ticketing system
        System.out.println("Welcome to the Customer Support System!");
        inputHandler.run();

    }
}
