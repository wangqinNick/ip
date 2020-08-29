package seedu.duck.command;

import seedu.duck.system.TaskManager;
import seedu.duck.ui.TextUi;
import seedu.duck.util.Message;

import static seedu.duck.ui.TextUi.printAllTasks;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    private static final String MESSAGE_USAGE = COMMAND_WORD;

    public ListCommand() {

    }

    @Override
    /**
     * If the list is not empty, return null. Do the display inside printAllTasks() function.
     * If the list is empty, display the empty list message by return a CommandResult object.
     */
    public CommandResult execute() {
        if (TaskManager.getTaskList().size()>0){
            String listMessage = printAllTasks(TaskManager.getTaskList());
            return new CommandResult((listMessage));
        } else {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }
    }
}
