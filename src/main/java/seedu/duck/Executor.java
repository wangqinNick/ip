package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.data.StateManager;
import seedu.duck.setting.SystemSetting;
import seedu.duck.storage.IOManager;
import seedu.duck.util.Message;
import java.io.IOException;

import static seedu.duck.util.Constant.DEFAULT_SYSTEM_LANGUAGE;
import static seedu.duck.util.Constant.SECONDARY_SYSTEM_LANGUAGE;

public class Executor {

    /**
     * Returns the command result after the command is executed
     *
     * @param parsedCommand The input from the user to be executed as a command
     * @return commandResult that contains the execute output information
     */
    public static CommandResult executeCommand(Command parsedCommand) {
        switch (SystemSetting.getSystemLanguage().toUpperCase()){
        case SECONDARY_SYSTEM_LANGUAGE:
        try{
            var commandResult = parsedCommand.executeInChinese();
            if (parsedCommand.getPromptType() == PromptType.EDIT){
                StateManager.saveState();
            }
            IOManager.saveAsJson();
            return commandResult;
        } catch (IOException ie){
            return new CommandResult(String.format(Message.MESSAGE_FILE_OPERATION_IO_ERROR_IN_ENGLISH, Message.JSON_FILE_PATH));
        }

        case DEFAULT_SYSTEM_LANGUAGE:
        default:
            try{
                var commandResult = parsedCommand.executeInEnglish();
                if (parsedCommand.getPromptType() == PromptType.EDIT){
                    StateManager.saveState();
                }
                IOManager.saveAsJson();
                return commandResult;
            } catch (IOException ie){
                return new CommandResult(String.format(Message.MESSAGE_FILE_OPERATION_IO_ERROR_IN_CHINESE, Message.JSON_FILE_PATH));
            }
        }
    }
}
