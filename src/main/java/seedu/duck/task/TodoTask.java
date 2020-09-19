package seedu.duck.task;

public class TodoTask extends Task {

    /**
     * Constructs a default to-do task (not done)
     * @param description task description
     */
    public TodoTask(String description) {
        this(description, false);
    }

    /**
     * Constructs a to-do task
     * @param description task description
     * @param isDone    if the task is done
     */
    public TodoTask(String description, boolean isDone) {
        super(description, TaskType.T, isDone);
    }
}
