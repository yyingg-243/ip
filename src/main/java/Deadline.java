public class Deadline extends Task {

    protected String by;

    /**
     * Construct a Deadline task with the description and deadline given.
     * @param description text that describe the task's details.
     * @param by due date to complete the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Return the task current status and detail in a formatted way.
     * @return a formatted string that represent the task.
     */
    @Override
    public String toString() {
        return "[D]" + getStatusIcon() + getDescription() + " (by: " + by + ")";
    }
}
