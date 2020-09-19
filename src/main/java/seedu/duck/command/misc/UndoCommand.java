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
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Undo the last command.\n"
            + "      Example: "
            + "undo";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 撤销上一步操作.\n"
            + "      例子: "
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
    public CommandResult executeInEnglish() {
        try {
            StateManager.undo();
            return new CommandResult(MESSAGE_UNDO_SUCCESS_IN_ENGLISH);
        } catch (IOException ioe) {
            return new CommandResult(MESSAGE_UNDO_UNSUCCESSFUL_IN_ENGLISH);
        } catch (EmptyStackException e) {
            return new CommandResult(MESSAGE_UNDO_AT_BEGINNING_IN_ENGLISH);
        }
    }

    @Override
    public CommandResult executeInChinese() {
        try {
            StateManager.undo();
            return new CommandResult(MESSAGE_UNDO_SUCCESS_IN_CHINESE);
        } catch (IOException ioe) {
            return new CommandResult(MESSAGE_UNDO_UNSUCCESSFUL_IN_CHINESE);
        } catch (EmptyStackException e) {
            return new CommandResult(MESSAGE_UNDO_AT_BEGINNING_IN_CHINESE);
        }
    }
}
