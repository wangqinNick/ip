package seedu.duck.command;

import seedu.duck.util.Message;

public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    public static final String MESSAGE_DONE = "  Nice! I've marked this duck.task as done:  [D] %s";
    public DoneCommand(int toDoneIndex) {
        super(toDoneIndex);
        this.promptType = PromptType.NONE;
    }
    @Override
    public CommandResult execute() {
        try {
            final var toDone = getTargetTask();
            toDone.setDone();
            return new CommandResult(String.format(MESSAGE_DONE, toDone.getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }
}
