package seedu.duck.command;

import seedu.duck.data.TaskManager;
import seedu.duck.util.Message;

public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Delete a task in the DUCK system.\n"
            + "      Example: "
            + "delete 1";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 删除一项指定任务.\n"
            + "      例子: "
            + "delete 1";

    public static final String MESSAGE_DELETE_TASK_SUCCESS_IN_ENGLISH = "Task: %1$s is deleted";
    public static final String MESSAGE_DELETE_TASK_SUCCESS_IN_CHINESE = "已删除任务: %1$s";

    public DeleteCommand(int toDeleteIndex) {
        super(toDeleteIndex);
        this.promptType = PromptType.EDIT;
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        try {
            final var toDelete = getTargetTask();
            TaskManager.removeTask(toDelete);
            return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS_IN_ENGLISH, toDelete.getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_ENGLISH);
        }
    }

    @Override
    public CommandResult executeInChinese() {
        try {
            final var toDelete = getTargetTask();
            TaskManager.removeTask(toDelete);
            return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS_IN_CHINESE, toDelete.getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_CHINESE);
        }
    }
}
