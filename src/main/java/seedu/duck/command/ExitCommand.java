package seedu.duck.command;

public class ExitCommand extends Command {
    public ExitCommand() {

    }
    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Exit.\n"
            + "      Example: "
            + "bye";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 退出程序.\n"
            + "      例子: "
            + "bye";

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        exitProgram();
        return null;
    }

    @Override
    public CommandResult executeInChinese() {
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
