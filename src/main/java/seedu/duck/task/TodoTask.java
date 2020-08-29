package seedu.duck.task;

import seedu.duck.util.Month;

public class TodoTask extends Task {
    public TodoTask(String description) {
        super(description, TaskType.T);
    }

    @Override
    public String getTaskInformation() {
        return String.format("[%c][%c] %s",
                getType(),
                getChar(),
                description);
    }
}
