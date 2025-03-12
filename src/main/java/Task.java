/**
 *
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Construct a Task with the description given.
     * @param description text that describe the task's details.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return current status of the task.
     * @return "[X]" if the task is done.
     */
    public String getStatusIcon() {
        return (isDone ? "[X] " : "[ ] ");
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks the task as undone.
     */
    public void unmark() {
        isDone = false;
    }

    /**
     * Return the detail of a task.
     * @return the task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the task current status and detail in a formatted way.
     * @return a formatted string that represent the task.
     */
    public String toString() {
        return "[T]" + getStatusIcon() +  getDescription() ;
    }

}

