package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.system.TaskManager;
import seedu.duck.task.Task;

import static seedu.duck.ui.TextUi.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_TODO_SUCCESS;

public class AddTodoCommand extends AddCommand {

    public static final String COMMAND_WORD = "todo";
    public static final char COMMAND_TYPE = 'T';
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Add a Todo task to the DUKE system.";
    public AddTodoCommand(Task toAdd) {
        super(toAdd);
    }

    @Override
    public CommandResult execute() {
        TaskManager.add(toAdd);
        return new CommandResult(String.format(
                MESSAGE_TODO_SUCCESS,
                toAdd.getIndex() + LIST_INDEX_OFFSET,
                COMMAND_TYPE,
                toAdd.getChar(),
                toAdd.getDescription()));
    }
}
