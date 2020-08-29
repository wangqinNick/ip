package seedu.duck;

import seedu.duck.command.Command;

import static seedu.duck.Duck.commandResult;
import static seedu.duck.Duck.taskManager;

public class Executor {
    static void executeCommand(Command parsedCommand) {
        try {
            parsedCommand.setData(taskManager);
            commandResult = parsedCommand.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
