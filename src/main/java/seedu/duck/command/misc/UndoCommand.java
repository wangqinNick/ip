package seedu.duck.command.misc;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.data.StateManager;

import java.io.IOException;
import java.util.EmptyStackException;

import static seedu.duck.util.Message.*;

public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";
    public static final String FORMAT = COMMAND_WORD;
    public static final String MESSAGE_USAGE = String.format(
            "%s - Undo the recent change made to the list\n"
                    + "Format: %s\n",
            COMMAND_WORD, FORMAT);

    public UndoCommand() {
        this.promptType = PromptType.INFORMATIVE;
    }

    @Override
    public CommandResult execute() {
        try {
            StateManager.undo();
            return new CommandResult(MESSAGE_UNDO_SUCCESS);
        } catch (IOException ioe) {
            return new CommandResult(MESSAGE_UNDO_UNSUCCESSFUL);
        } catch (EmptyStackException e) {
            return new CommandResult(MESSAGE_UNDO_AT_BEGINNING);
        }
    }
}
