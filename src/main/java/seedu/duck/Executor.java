package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import static seedu.duck.Duck.taskManager;

public class Executor {

    private static CommandResult commandResult;
    public static CommandResult executeCommand(Command parsedCommand) {
        try {
            parsedCommand.setData(taskManager);
            return parsedCommand.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return commandResult;
    }
}
