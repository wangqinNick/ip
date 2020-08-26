package command;

import ui.TextUi;

public class IncorrectCommand extends Command {

    public final String feedbackToUser;

    public IncorrectCommand(String commandWord) {
        this.feedbackToUser = commandWord;
    }

    @Override
    public CommandResult execute() {
        TextUi.printAlert();
        return new CommandResult(feedbackToUser);
    }
}
