package seedu.duck.command;

import static seedu.duck.ui.TextUi.printAlert;

public class IncorrectCommand extends Command {
    public final String feedbackToUser;

    public IncorrectCommand(String commandWord) {
        this.feedbackToUser = commandWord;
    }

    @Override
    public CommandResult execute() {
        printAlert();
        return new CommandResult(feedbackToUser);
    }
}
