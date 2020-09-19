package seedu.duck.command;

public class ExitCommand extends Command {
    public ExitCommand() {

    }
    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Exit.\n"
            + "      Example: "
            + "bye";

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult execute() {
        exitProgram();
        return null;
    }

    /**
     * Exits the runtime.
     */
    private static void exitProgram() {
        System.exit(0);
    }
}
