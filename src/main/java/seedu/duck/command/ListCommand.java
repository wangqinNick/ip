package seedu.duck.command;

import seedu.duck.ui.TextUi;
import seedu.duck.util.Message;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    private static final String MESSAGE_USAGE = COMMAND_WORD;
    private static String listMessage;
    public ListCommand() {

    }

    @Override
    /**
     * If the list is not empty, return null. Do the display inside printAllTasks() function.
     * If the list is empty, display the empty list message by return a CommandResult object.
     */
    public CommandResult execute() {
        if (taskManager.getTaskList().size()>0){
            listMessage = TextUi.printAllTasks(taskManager.getTaskList());
            return new CommandResult((listMessage));
        } else {
            return new CommandResult(Message.MESSAGE_EMPTY_LIST);
        }
    }
}
