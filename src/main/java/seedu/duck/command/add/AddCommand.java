package seedu.duck.command.add;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.system.TaskManager;
import seedu.duck.task.Task;

import static seedu.duck.util.Message.messageAddTaskSuccess;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    private Task toAdd;

    public AddCommand() {
    }

    @Override
    public CommandResult execute() {
        TaskManager.add(toAdd);
        return new CommandResult(messageAddTaskSuccess(toAdd.getDescription()));
    }

    public AddCommand(Task toAdd) {
        this.toAdd = toAdd;
    }

}
