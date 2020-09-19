package seedu.duck.task;

public class TodoTask extends Task {
    public TodoTask(String description) {
        this(description, false);
    }

    public TodoTask(String description, boolean isDone) {
        super(description, TaskType.T, isDone);
    }
}
