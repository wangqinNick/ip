package seedu.duck.command;

import seedu.duck.data.TaskManager;
import static seedu.duck.ui.TextUi.getAppendedTasksMessage;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": List all tasks in the system.\n"
            + "    Example: " + COMMAND_WORD;

    public ListCommand() {
        this.promptType = PromptType.NONE;
    }

    @Override
    public CommandResult execute() {
        if (TaskManager.getTaskList().size()>0){
            var listMessage = getAppendedTasksMessage(TaskManager.getTaskList());
            return new CommandResult((listMessage));
        } else {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }
    }
}
