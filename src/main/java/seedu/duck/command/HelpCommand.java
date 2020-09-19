package seedu.duck.command;

import seedu.duck.command.add.AddDeadlineCommand;
import seedu.duck.command.add.AddEventCommand;
import seedu.duck.command.add.AddTodoCommand;
import seedu.duck.command.misc.UndoCommand;

public class HelpCommand extends Command{
    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Shows program usage instructions.\n"
            + "    Example: " + COMMAND_WORD;
    private static final String feedbackToUser = AddTodoCommand.MESSAGE_USAGE
            + "\n" + "  "+ AddDeadlineCommand.MESSAGE_USAGE
            + "\n" + "  "+ AddEventCommand.MESSAGE_USAGE
            + "\n" + "  "+ DeleteCommand.MESSAGE_USAGE
            + "\n" + "  "+ FindCommand.MESSAGE_USAGE
            + "\n" + "  "+ ListCommand.MESSAGE_USAGE
            + "\n" + "  "+ HelpCommand.MESSAGE_USAGE
            + "\n" + "  "+ UndoCommand.MESSAGE_USAGE
            + "\n" + "  "+ ExitCommand.MESSAGE_USAGE;
    public HelpCommand() {
        this.promptType = PromptType.INFORMATIVE;
    }

    public static String getFeedbackToUser() {
        return feedbackToUser;
    }

    public CommandResult execute() {
        return new CommandResult(feedbackToUser);
    }

}
