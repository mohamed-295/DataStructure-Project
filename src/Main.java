
public class Main {

    public static void main(String[] args) {

        CustomerSupportSystem system = new CustomerSupportSystem();


        InputHandler inputHandler = new InputHandler(system);

        System.out.println("Welcome to the Customer Support System!");
        inputHandler.run();

    }
}
