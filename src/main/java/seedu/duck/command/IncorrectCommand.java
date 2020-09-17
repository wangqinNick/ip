package seedu.duck.command;

public class IncorrectCommand extends Command {
    public final String feedbackToUser;

    public IncorrectCommand(String commandWord) {
        this.feedbackToUser = commandWord;
        this.promptType = PromptType.WARNING;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedbackToUser);
    }
}
