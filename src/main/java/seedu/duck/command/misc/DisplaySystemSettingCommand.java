package seedu.duck.command.misc;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.setting.SystemSetting;

public class DisplaySystemSettingCommand extends Command {
    public static final String COMMAND_WORD = "sys";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Shows system preferences.\n"
            + "      Example: "
            + COMMAND_WORD;

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 显示当前系统设定.\n"
            + "      例子: "
            + COMMAND_WORD;

    public DisplaySystemSettingCommand() {
        this.promptType = PromptType.INFORMATIVE;
    }

    private final String feedbackToUserInEnglish =
            "  "+ "System Language: " + SystemSetting.getSystemLanguageInString() +
            "\n  "+ "System Music: " + SystemSetting.getBackgroundMusicViewInString() +
            "\n  "+ "System Duplicated tasks: " + SystemSetting.getIsDuplicatedTaskAllowedInString() +
            "\n  "+ "Username: " + SystemSetting.getUsername() +
            "\n  "+ "Password: " + SystemSetting.getPassword();


    private final String feedbackToUserInChinese =
            "  "+ "系统语言: " + SystemSetting.getSystemLanguageInStringInChinese() +
            "\n  "+ "系统音乐: " + SystemSetting.getBackgroundMusicViewInStringInChinese() +
            "\n  "+ "是否允许重复添加相同任务: " + SystemSetting.getIsDuplicatedTaskAllowedInStringInChinese() +
            "\n  "+ "用户名: " + SystemSetting.getUsername() +
            "\n  "+ "密码: " + SystemSetting.getPassword();

    @Override
    public CommandResult executeInEnglish() {
        return new CommandResult(feedbackToUserInEnglish);
    }

    @Override
    public CommandResult executeInChinese() {
        return new CommandResult(feedbackToUserInChinese);
    }
}
