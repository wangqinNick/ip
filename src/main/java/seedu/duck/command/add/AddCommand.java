package seedu.duck.command.add;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;

import static seedu.duck.util.Message.messageAddTaskSuccess;

/**
 * A dummy class for dummy add command
 * The dummy add command is Level-1 for Duck system and was abandoned
 * after having more specific add commands
 */
public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    protected Task toAdd;

    public AddCommand() {
    }

    public AddCommand(Task toAdd) {
        this.toAdd = toAdd;
    }

    /**
     * A dummy execute function for dummy add command
     * The dummy add command was abandoned
     *
     * @return the command result
     */
    @Override
    public CommandResult execute() {
        TaskManager.add(toAdd);
        return new CommandResult(messageAddTaskSuccess(toAdd.getDescription()));
    }
}
