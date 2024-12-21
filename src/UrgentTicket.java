/**
 * Represents an urgent ticket in the customer support system.
 * Extends the base Ticket class to include priority information.
 */
public class UrgentTicket extends Ticket {
    private int priority; // Priority level (lower number = higher priority)

    /**
     * Constructor to create an urgent ticket.
     * @param id          the unique ID of the ticket
     * @param description a brief description of the ticket
     * @param priority    the priority level of the ticket
     */
    public UrgentTicket(int id, String description, int priority) {
        super(id, description);
        this.priority = priority;
    }

    /**
     * Retrieves the priority of the ticket.
     * @return the priority level
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Updates the priority of the ticket.
     * @param priority the new priority level
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Generates a string representation of the urgent ticket.
     * @return a string describing the urgent ticket
     */
    @Override
    public String toString() {
        return "UrgentTicket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
