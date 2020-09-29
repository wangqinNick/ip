package seedu.duck.command.misc;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.setting.SystemSetting;

public class AllowDuplicatedTaskCommand extends Command {
    public static final String COMMAND_WORD = "allow";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Change preferences for duplicated tasks. 1 for allowing, 0 for not allowing.\n"
            + "      Example: "
            + COMMAND_WORD + "1";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 更改系统设定是否允许重复任务。 1 为允许，0 为不允许。\n"
            + "      例子: "
            + COMMAND_WORD + "1";

    private boolean isAllowed;
    public AllowDuplicatedTaskCommand(boolean isAllowed) {
        this.isAllowed = isAllowed;
        this.promptType = PromptType.INFORMATIVE;
    }

    @Override
    public CommandResult executeInEnglish() {
        SystemSetting.setIsDuplicatedAllowed(isAllowed);
        return new CommandResult("Changed Successfully!");
    }

    @Override
    public CommandResult executeInChinese() {
        SystemSetting.setIsDuplicatedAllowed(isAllowed);
        return new CommandResult("Changed Successfully!");
    }
}
