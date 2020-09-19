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
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Undo the last command.\n"
            + "      Example: "
            + "undo";

    public UndoCommand() {
        this.promptType = PromptType.INFORMATIVE;
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
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
