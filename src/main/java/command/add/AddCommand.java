package command.add;

import command.Command;
import command.CommandResult;
import system.TaskManager;
import task.Task;
import util.Message;

import static util.Message.messageAddTaskSuccess;

public class AddCommand extends Command {

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
