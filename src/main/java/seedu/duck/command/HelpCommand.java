package seedu.duck.command;

import seedu.duck.command.add.AddDeadlineCommand;
import seedu.duck.command.add.AddEventCommand;
import seedu.duck.command.add.AddTodoCommand;
import seedu.duck.command.misc.HistoryTraverseCommand;
import seedu.duck.command.misc.UndoCommand;

public class HelpCommand extends Command{
    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Shows program usage instructions.\n"
            + "      Example: "
            + COMMAND_WORD;

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 现实程序所有可执行命令.\n"
            + "      例子: "
            + COMMAND_WORD;

    private static final String feedbackToUserInEnglish =
            "  "+ AddTodoCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ AddDeadlineCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ AddEventCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ UndoCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ DeleteCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ DoneCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ DueCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ FindCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ ListCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ HelpCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ ClearCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ ChangeVolumeCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ HistoryTraverseCommand.MESSAGE_USAGE_IN_ENGLISH
                    + "\n" + "  "+ ExitCommand.MESSAGE_USAGE_IN_ENGLISH;

    private static final String feedbackToUserInChinese =
            "  "+ AddTodoCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ AddDeadlineCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ AddEventCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ UndoCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ DeleteCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ DoneCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ DueCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ FindCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ ListCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ HelpCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ ClearCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ ChangeVolumeCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ HistoryTraverseCommand.MESSAGE_USAGE_IN_CHINESE
                    + "\n" + "  "+ ExitCommand.MESSAGE_USAGE_IN_CHINESE;

    public HelpCommand() {
        this.promptType = PromptType.INFORMATIVE;
    }

    /**
     * Returns the execute-result to user in English
     * @return the execute result
     */
    public static String getFeedbackToUserInEnglish() {
        return feedbackToUserInEnglish;
    }

    /**
     * Returns the execute-result to user in Chinese
     * @return the execute result
     */
    public static String getFeedbackToUserInChinese() {
        return feedbackToUserInChinese;
    }


    /**
     * Executes the command in English
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        return new CommandResult(feedbackToUserInEnglish);
    }

    /**
     * Executes the command in Chinese
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInChinese() {
        return new CommandResult(feedbackToUserInChinese);
    }
}
