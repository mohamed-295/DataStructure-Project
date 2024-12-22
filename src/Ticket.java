
public class Ticket {
    protected int id;
    protected String description;

    /**
     * @param id          the unique ID of the ticket
     * @param description a brief description of the ticket
     */
    public Ticket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * @return the unique ticket ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return the ticket description
     */
    public String getDescription() {
        return description;
    }

    /**
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
