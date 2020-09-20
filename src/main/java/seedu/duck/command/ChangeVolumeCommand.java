package seedu.duck.command;

import seedu.duck.setting.SystemSetting;

import static seedu.duck.util.Constant.DEFAULT_SYSTEM_MUSIC;

public class ChangeVolumeCommand extends Command {

    private double value;
    public static final String COMMAND_WORD = "volume";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Change the volume of the background Music.\n"
            + ": The value should be within 0 - 1.0.\n"
            + "      Example: "
            + "volume 0.9";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 调整音量.\n"
            + ": 指定的值应该在 0 - 1.0.\n"
            + "      例子: "
            + "volume 0.9";

    public ChangeVolumeCommand(double value) {
        this.value = value;
        this.promptType = PromptType.NONE;
    }

    @Override
    public CommandResult executeInEnglish() {
        SystemSetting.setBackgroundMediaView(DEFAULT_SYSTEM_MUSIC, value, true);
        return new CommandResult("Volume has been changed successfully");
    }

    @Override
    public CommandResult executeInChinese() {
        SystemSetting.setBackgroundMediaView(DEFAULT_SYSTEM_MUSIC, value, true);
        return new CommandResult("音量已修改");

    }
}
