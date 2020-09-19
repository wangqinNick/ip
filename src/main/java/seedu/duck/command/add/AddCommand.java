package seedu.duck.command.add;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;

import static seedu.duck.util.Message.messageAddTaskSuccess;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    protected Task toAdd;

    public AddCommand() {
    }

    public AddCommand(Task toAdd) {
        this.toAdd = toAdd;
    }



    @Override
    public CommandResult execute() {
        TaskManager.add(toAdd);
        return new CommandResult(messageAddTaskSuccess(toAdd.getDescription()));
    }


}
