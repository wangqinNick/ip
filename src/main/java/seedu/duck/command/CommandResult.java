package seedu.duck.command;

/** Display the execute result, by constructing a CommandResult object **/
public class CommandResult {
    private final String feedbackToUser;

    /**
     * Constructs the CommandResult with information String feedbackToUser
     * @param feedbackToUser feedback to user
     */
    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    /**
     * Returns the feedback String in the command result
     * @return the feedback String
     */
    public String getFeedbackToUser() {
        return feedbackToUser;
    }
}