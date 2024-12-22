import java.util.*;


public class CustomerSupportSystem {
    private final Queue<Ticket> regularTickets;
    private final PriorityQueue<UrgentTicket> urgentTickets;
    private int ticketCounter;


    public CustomerSupportSystem() {
        this.regularTickets = new LinkedList<>();
        this.urgentTickets = new PriorityQueue<>(Comparator.comparingInt(UrgentTicket::getPriority));
        this.ticketCounter = 0;
    }

    /**
     * @param description the description of the ticket
     * @param urgent      flag indicating if the ticket is urgent
     * @param priority    the priority of the ticket (1-10, where 1 is the highest priority)
     * @return the ID of the created ticket
     */
    public int addUrgentTicket(String description, boolean urgent, int priority) {
        ticketCounter++;
        UrgentTicket ticket = new UrgentTicket(ticketCounter, description, priority);
        urgentTickets.add(ticket);
        return ticketCounter;
    }

    /**
     * @param description the description of the ticket
     * @param urgent      flag indicating if the ticket is urgent
     * @return the ID of the created ticket
     */
    public int addRegularTicket(String description, boolean urgent) {
        ticketCounter++;
        Ticket ticket = new Ticket(ticketCounter, description);
        regularTickets.add(ticket);
        return ticketCounter;
    }

    /**
     * @return the next ticket to be processed, or null if no tickets are available
     */
    public Ticket processNextTicket() {
        if (!urgentTickets.isEmpty()) {
            return urgentTickets.poll();
        } else if (!regularTickets.isEmpty()) {
            return regularTickets.poll();
        }
        return null;
    }

    /**
     * @param id the ID of the ticket to search for
     * @return the ticket if found, or null if not found
     */
    public Ticket searchTicket(int id) {
        for (UrgentTicket ticket : urgentTickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        for (Ticket ticket : regularTickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * @param ticketId    the ID of the ticket to reprioritize
     * @param newPriority the new priority to assign to the ticket
     */
    public void reprioritizeTicket(int ticketId, int newPriority) {
        Ticket ticket = searchTicket(ticketId);
        if (ticket instanceof UrgentTicket) {
            UrgentTicket urgentTicket = (UrgentTicket) ticket;
            if (urgentTickets.contains(urgentTicket)) {
                urgentTickets.remove(urgentTicket);
                urgentTicket.setPriority(newPriority);
                urgentTickets.add(urgentTicket);
                System.out.println(ConsoleColor.GREEN + "✅ Ticket reprioritized successfully!" + ConsoleColor.RESET);
            }
        } else {
            System.out.println(ConsoleColor.YELLOW + "⚠️ Ticket not found or is not an urgent ticket." + ConsoleColor.RESET);
        }
    }


    public void clearAllTickets() {
        if (urgentTickets.isEmpty() && regularTickets.isEmpty()) {
            System.out.println(ConsoleColor.YELLOW + "⚠️ No tickets to clear." + ConsoleColor.RESET);
            return;
        }
        urgentTickets.clear();
        regularTickets.clear();
        ticketCounter = 0;
        System.out.println(ConsoleColor.GREEN + "✅ All tickets cleared." + ConsoleColor.RESET);
    }


    public void displayTickets() {
        if (!urgentTickets.isEmpty()) {
            System.out.println(ConsoleColor.RED + "\n🔴 Urgent Tickets:" + ConsoleColor.RESET);
            urgentTickets.forEach(System.out::println);
        } else {
            System.out.println(ConsoleColor.RED + "\n🔴 No urgent tickets available." + ConsoleColor.RESET);
        }

        if (!regularTickets.isEmpty()) {
            System.out.println(ConsoleColor.GREEN + "\n🟢 Regular Tickets:" + ConsoleColor.RESET);
            regularTickets.forEach(System.out::println);
        } else {
            System.out.println(ConsoleColor.GREEN + "\n🟢 No regular tickets available." + ConsoleColor.RESET);
        }
    }
}
