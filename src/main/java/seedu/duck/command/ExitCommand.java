package seedu.duck.command;

public class ExitCommand extends Command {
    public ExitCommand() {

    }
    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Exit the program.";

    @Override
    public CommandResult execute() {
        exitProgram();
        return null;
    }
    /**
     * Displays the goodbye message and exits the runtime.
     */
    private static void exitProgram() {
        System.exit(0);
    }
}
