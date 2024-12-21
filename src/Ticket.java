/**
 * Represents a generic ticket in the customer support system.
 * This serves as a base class for different types of tickets.
 */
public class Ticket {
    protected int id; // Unique identifier for the ticket
    protected String description; // Description of the ticket

    /**
     * Constructor to create a ticket.
     * @param id          the unique ID of the ticket
     * @param description a brief description of the ticket
     */
    public Ticket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Retrieves the ticket ID.
     * @return the unique ticket ID
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the description of the ticket.
     * @return the ticket description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Generates a string representation of the ticket.
     * @return a string describing the ticket
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
