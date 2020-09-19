package seedu.duck.command;

import seedu.duck.data.TaskManager;
import static seedu.duck.ui.TextUi.getAppendedTasksMessage;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST_IN_ENGLISH;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": List all tasks in the system.\n"
            + "      Example: "
            + COMMAND_WORD;

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 列出所有任务.\n"
            + "      例子: "
            + COMMAND_WORD;

    public ListCommand() {
        this.promptType = PromptType.NONE;
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        if (TaskManager.getTaskList().size()>0){
            var listMessage = getAppendedTasksMessage(TaskManager.getTaskList());
            return new CommandResult((listMessage));
        } else {
            return new CommandResult(MESSAGE_EMPTY_LIST_IN_ENGLISH);
        }
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInChinese() {
        if (TaskManager.getTaskList().size()>0){
            var listMessage = getAppendedTasksMessage(TaskManager.getTaskList());
            return new CommandResult((listMessage));
        } else {
            return new CommandResult(MESSAGE_EMPTY_LIST_IN_CHINESE);
        }
    }
}
