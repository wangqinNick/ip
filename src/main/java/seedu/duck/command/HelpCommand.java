package seedu.duck.command;

import seedu.duck.command.add.AddDeadlineCommand;
import seedu.duck.command.add.AddEventCommand;
import seedu.duck.command.add.AddTodoCommand;

public class HelpCommand extends Command{
    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "    Example: " + COMMAND_WORD;

    public HelpCommand() {
        this.promptType = PromptType.INFORMATIVE;
    }


    public CommandResult execute() {
        return new CommandResult(
                        AddTodoCommand.MESSAGE_USAGE
                        + "\n" + "  "+ AddDeadlineCommand.MESSAGE_USAGE
                        + "\n" + "  "+ AddEventCommand.MESSAGE_USAGE
                        + "\n" + "  "+ DeleteCommand.MESSAGE_USAGE
                        + "\n" + "  "+ FindCommand.MESSAGE_USAGE
                        + "\n" + "  "+ ListCommand.MESSAGE_USAGE
                        + "\n" + "  "+ HelpCommand.MESSAGE_USAGE
                        + "\n" + "  "+ ExitCommand.MESSAGE_USAGE
        );
    }

}
