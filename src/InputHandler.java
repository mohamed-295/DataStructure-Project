import java.util.Scanner;


public class InputHandler {
    private final CustomerSupportSystem system;
    private final Scanner scanner;

    /**
     * @param system the instance of CustomerSupportSystem to manage tickets
     */
    public InputHandler(CustomerSupportSystem system) {
        this.system = system;
        this.scanner = new Scanner(System.in);
    }


    public void run() {
        while (true) {
            displayMenu();
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "T":
                    handleAddTicket();
                    break;
                case "P":
                    handleProcessNextTicket();
                    break;
                case "S":
                    handleSearchTicket();
                    break;
                case "R":
                    handleReprioritizeTicket();
                    break;
                case "D":
                    system.displayTickets();
                    break;
                case "C":
                    system.clearAllTickets();
                    break;
                case "X":
                    System.out.println("\n" + ConsoleColor.YELLOW + "Thank you for using the system. Goodbye!" + ConsoleColor.RESET);
                    return;
                default:
                    System.out.println(ConsoleColor.YELLOW + "⚠️ Invalid option. Please select from the menu." + ConsoleColor.RESET);
            }
        }
    }


    private void displayMenu() {
        System.out.println(ConsoleColor.BLUE + "\n==========================");
        System.out.println("  Customer Support System ");
        System.out.println("==========================");
        System.out.println("T - Add Ticket");
        System.out.println("P - Process Next Ticket");
        System.out.println("S - Search for Ticket by ID");
        System.out.println("R - Reprioritize a Ticket");
        System.out.println("D - Display All Tickets");
        System.out.println("C - Clear All Tickets");
        System.out.println("X - Exit Program");
        System.out.println("==========================");
        System.out.print("Enter your choice: " + ConsoleColor.RESET);
    }


    private void handleAddTicket() {
        System.out.print("\nEnter the ticket description or Press Enter to return to menu: ");
        String description = scanner.nextLine();
        if (description.isEmpty()) {
            return;
        }
        boolean urgent = false;
        while (true) {
            System.out.print("Is this ticket urgent? (Y/N): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) {
                urgent = true;
                break;
            } else if (input.equalsIgnoreCase("N")) {
                urgent = false;
                break;
            } else {
                System.out.println(ConsoleColor.YELLOW + "⚠️ Invalid input. Please enter 'Y' for Yes or 'N' for No." + ConsoleColor.RESET);
            }
        }

        int priority = 0;
        if (urgent) {
            System.out.print("Enter the ticket priority from 1 to 10 (lower number = higher priority): ");
            while (true) {
                try {
                    int inputPriority = Integer.parseInt(scanner.nextLine().trim());
                    if (inputPriority >= 1 && inputPriority <= 10) {
                        priority = inputPriority;
                        break;
                    } else {
                        System.out.print(ConsoleColor.YELLOW + "⚠️ Invalid input. Enter a priority between 1 and 10: " + ConsoleColor.RESET);
                    }
                } catch (NumberFormatException e) {
                    System.out.print(ConsoleColor.YELLOW + "⚠️ Invalid input. Enter a valid number: " + ConsoleColor.RESET);
                }
            }
        }

        int ticketId = urgent
                ? system.addUrgentTicket(description, true, priority)
                : system.addRegularTicket(description, false);

        System.out.println(ConsoleColor.GREEN + "\n✅ Ticket added successfully! Ticket ID: " + ticketId + ConsoleColor.RESET);
    }


    private void handleProcessNextTicket() {
        Ticket nextTicket = system.processNextTicket();
        if (nextTicket != null) {
            System.out.println(ConsoleColor.CYAN + "\n🔄 Processing Ticket: " + nextTicket + ConsoleColor.RESET);
        } else {
            System.out.println(ConsoleColor.YELLOW + "\n⚠️ No tickets available to process." + ConsoleColor.RESET);
        }
    }


    private void handleSearchTicket() {
        System.out.print("\nEnter the ticket ID to search or Press Enter to return to menu: ");
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return;
            }
            int id = Integer.parseInt(input);
            Ticket ticket = system.searchTicket(id);
            if (ticket != null) {
                System.out.println(ConsoleColor.CYAN + "\n🔍 Found Ticket: " + ticket + ConsoleColor.RESET);
            } else {
                System.out.println(ConsoleColor.YELLOW + "\n⚠️ Ticket not found." + ConsoleColor.RESET);
            }
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColor.YELLOW + "\n⚠️ Invalid ticket ID." + ConsoleColor.RESET);
        }
    }


    private void handleReprioritizeTicket() {
        System.out.print("\nEnter the ticket ID to reprioritize or Press Enter to return to menu: ");
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return;
            }
            int id = Integer.parseInt(input);
            System.out.print("Enter the new priority from 1 to 10 (lower number = higher priority): ");
            int newPriority = Integer.parseInt(scanner.nextLine().trim());
            system.reprioritizeTicket(id, newPriority);
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColor.YELLOW + "\n⚠️ Invalid input. Please enter valid numbers." + ConsoleColor.RESET);
        }
    }
}
