package seedu.duck.command;

import seedu.duck.data.TaskManager;

import static seedu.duck.util.Message.MESSAGE_CLEAR_SUCCESS_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_CLEAR_SUCCESS_IN_ENGLISH;


public class ClearCommand extends Command {
    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Delete all tasks in the DUCK system.\n"
            + "      Example: "
            + "clear";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 删除系统中所有的任务.\n"
            + "      例子: "
            + "clear";

    public ClearCommand() {
        this.promptType = PromptType.EDIT;
    }

    @Override
    public CommandResult executeInEnglish() {
        TaskManager.clear();
        return new CommandResult(MESSAGE_CLEAR_SUCCESS_IN_ENGLISH);
    }

    @Override
    public CommandResult executeInChinese() {
        TaskManager.clear();
        return new CommandResult(MESSAGE_CLEAR_SUCCESS_IN_CHINESE);
    }
}
