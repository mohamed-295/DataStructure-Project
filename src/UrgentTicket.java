
public class UrgentTicket extends Ticket {
    private int priority;

    /**
     * @param id          the unique ID of the ticket
     * @param description a brief description of the ticket
     * @param priority    the priority level of the ticket
     */
    public UrgentTicket(int id, String description, int priority) {
        super(id, description);
        this.priority = priority;
    }

    /**
     * @return the priority level
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the new priority level
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
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
