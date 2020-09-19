package seedu.duck.command;

import seedu.duck.util.Message;

public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Mark a task as done.\n"
            + "      Example: "
            + "done 1";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 将指定任务标记为完成.\n"
            + "      例子: "
            + "done 1";
    public static final String MESSAGE_DONE_IN_ENGLISH = "  Nice! I've marked this duck.task as done:  [D] %s";
    public static final String MESSAGE_DONE_IN_CHINESE = "  好的！我已经将这个任务标记为完成:  [D] %s";

    public DoneCommand(int toDoneIndex) {
        super(toDoneIndex);
        this.promptType = PromptType.EDIT;
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        try {
            final var toDone = getTargetTask();
            toDone.setDone();
            return new CommandResult(String.format(MESSAGE_DONE_IN_ENGLISH, toDone.getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_ENGLISH);
        }
    }

    @Override
    public CommandResult executeInChinese() {
        try {
            final var toDone = getTargetTask();
            toDone.setDone();
            return new CommandResult(String.format(MESSAGE_DONE_IN_CHINESE, toDone.getDescription()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_CHINESE);
        }
    }
}
