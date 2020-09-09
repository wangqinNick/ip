package seedu.duck.command;

import seedu.duck.system.TaskManager;
import seedu.duck.task.Task;
import seedu.duck.util.Message;

public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE_1 = COMMAND_WORD
            + ": Deletes the task by the index number.";
    ;
    public static final String MESSAGE_USAGE_2 = "    Parameters: INDEX";
    public static final String MESSAGE_USAGE_3 = "    Example: " + COMMAND_WORD + " 1";
    public static final String MESSAGE_DELETE_TASK_SUCCESS = "Deleted Task: %1$s";

    public DeleteCommand(int targetVisibleIndex) {
        super(targetVisibleIndex);
    }

    @Override
    public CommandResult execute() {
        try {
            TaskManager.removeTask(getTargetIndex());
            return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS, getTargetTask().getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }
}
