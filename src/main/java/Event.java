public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Construct an Event task with the description and time details given.
     * @param description text that describe the task's details.
     * @param from start time of the event.
     * @param to end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Return the task current status and detail in a formatted way.
     * @return a formatted string that represent the task.
     */
    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + getDescription() + " (from: " + from + " to: " + to + ")";
    }
}
