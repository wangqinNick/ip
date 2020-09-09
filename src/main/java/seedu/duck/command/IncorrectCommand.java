package seedu.duck.command;

public class IncorrectCommand extends Command {
    public final String feedbackToUser;

    public IncorrectCommand(String commandWord) {
        this.feedbackToUser = commandWord;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedbackToUser);
    }
}
