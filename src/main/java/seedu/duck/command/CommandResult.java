package seedu.duck.command;

import seedu.duck.ui.TextUi;

/** Display the execute result, by constructing a CommandResult object **/
public class CommandResult {
    private final String feedbackToUser;

    /**
     * @parameter: feedbackToUser Execute feedback to user
     */
    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }
}