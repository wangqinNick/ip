package seedu.duck.command;

import seedu.duck.system.TaskManager;
import seedu.duck.task.Task;
import seedu.duck.util.Message;

public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Delete a task in the DUCK system.\n"
            + "      Example: "
            + "delete 1";

    public static final String MESSAGE_DELETE_TASK_SUCCESS = "Deleted Task: %1$s";

    public DeleteCommand(int toDeleteIndex) {
        super(toDeleteIndex-2);
        this.promptType = PromptType.NONE;
    }

    @Override
    public CommandResult execute() {
        try {
            final var toDelete = getTargetTask();
            TaskManager.removeTask(toDelete);
            return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS, toDelete.getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }
}
