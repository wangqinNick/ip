package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import static seedu.duck.Duck.taskManager;

public class Executor {
    public static CommandResult executeCommand(Command parsedCommand) {
        parsedCommand.setData(taskManager);
        return parsedCommand.execute();
    }
}
