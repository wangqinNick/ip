package seedu.duck.command;

import seedu.duck.setting.SystemSetting;

import static seedu.duck.util.Constant.DEFAULT_SYSTEM_LANGUAGE;
import static seedu.duck.util.Constant.SECONDARY_SYSTEM_LANGUAGE;

public class ChangeLanguageCommand extends Command {
    public static final String COMMAND_WORD = "change";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Change the UI language.\n"
            + "      Example: "
            + COMMAND_WORD
            + " Chinese";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 改变系统界面语言\n"
            + "      例子: "
            + COMMAND_WORD
            + " Chinese";

    private String language;

    public ChangeLanguageCommand(String language) {
        this.language = language;
        this.promptType = PromptType.NONE;
    }

    @Override
    public CommandResult executeInEnglish() {
        switch (language.toUpperCase()){
        case SECONDARY_SYSTEM_LANGUAGE:
            SystemSetting.setSystemLanguage(SECONDARY_SYSTEM_LANGUAGE);
            return new CommandResult("系统语言已转换为中文");
        default:
        case DEFAULT_SYSTEM_LANGUAGE:
            SystemSetting.setSystemLanguage(SECONDARY_SYSTEM_LANGUAGE);
            return new CommandResult("System Language has been changed to English");
        }
    }

    @Override
    public CommandResult executeInChinese() {
        switch (language.toUpperCase()){
        case SECONDARY_SYSTEM_LANGUAGE:
            SystemSetting.setSystemLanguage("Chinese");
            return new CommandResult("系统语言已转换为中文");
        default:
        case DEFAULT_SYSTEM_LANGUAGE:
            SystemSetting.setSystemLanguage("English");
            return new CommandResult("System Language has been changed to English");
        }
    }
}
