package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.parser.Parser;

public class Executor {
    /* Variables to transit between parsing regular commands and prompts */
    private static PromptType promptType = PromptType.NONE;
    /**
     * Prepares the system to prepare a prompt for the user to input indices.
     */
    public static void preparePromptIndices() {
        promptType = PromptType.INDICES;
    }

    /**
     * Prepares the system to prepare a confirmation prompt for the user.
     */
    public static void preparePromptConfirmation() {
        promptType = PromptType.CONFIRMATION;
    }

    /**
     * Prepares the system to terminate prompt mode and revert to normal parsing of commands.
     */
    public static void terminatePrompt() {
        promptType = PromptType.NONE;
    }
    /**
     * Executes command.
     *
     * @param userInput The input from the user to be parsed and executed as a command
     * @return commandResult that contains the execute output information
     */
    public static CommandResult executeCommand(String userInput) {
        return null;
    }

}
