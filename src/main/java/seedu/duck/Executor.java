package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.data.StateManager;
import seedu.duck.storage.IOManager;
import seedu.duck.util.Message;

import java.io.IOException;

public class Executor {
    /**
     * Executes command.
     *
     * @param parsedCommand The input from the user to be executed as a command
     * @return commandResult that contains the execute output information
     */
    public static CommandResult executeCommand(Command parsedCommand) {
        try{
            CommandResult commandResult = parsedCommand.execute();
            if (parsedCommand.getPromptType() == PromptType.EDIT){
                StateManager.saveState();
            }
            IOManager.saveAsJson();
            return commandResult;
        } catch (IOException ie){
            return new CommandResult(String.format(Message.MESSAGE_FILE_OPERATION_IO_ERROR, Message.JSON_FILE_PATH));
        }
    }
}
