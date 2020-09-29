package seedu.duck.command;

import seedu.duck.setting.SystemSetting;
import seedu.duck.storage.IOManager;

import java.io.IOException;

import static seedu.duck.util.Constant.DEFAULT_PASSWORD;
import static seedu.duck.util.Constant.DEFAULT_USERNAME;

public class ChangePasswordCommand extends Command {
    public static final String COMMAND_WORD = "pw";

    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Change the password.\n"
            + "      Example: "
            + COMMAND_WORD + " 123";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 更改密码.\n"
            + "      例子: "
            + COMMAND_WORD + " 123";

    private final String password;

    public ChangePasswordCommand(String password) {
        this.password = password;
        this.promptType = PromptType.INFORMATIVE;
    }

    @Override
    public CommandResult executeInEnglish() {
        SystemSetting.setPassword(password);
        try {
            IOManager.saveUserInfo();
        } catch (IOException ioe){
            SystemSetting.setUsername(DEFAULT_USERNAME);
            SystemSetting.setPassword(DEFAULT_PASSWORD);
            return new CommandResult("Failed! Invasion detected, user Info recovered to default!");
        }
        return new CommandResult("Success!");
    }

    @Override
    public CommandResult executeInChinese() {
        SystemSetting.setPassword(password);
        try {
            IOManager.saveUserInfo();
        } catch (IOException ioe){
            SystemSetting.setUsername(DEFAULT_USERNAME);
            SystemSetting.setPassword(DEFAULT_PASSWORD);
            return new CommandResult("失败! 疑似遭到入侵，用户信息重置为原始默认信息!");
        }
        return new CommandResult("成功!");
    }
}
