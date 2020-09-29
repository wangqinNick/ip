package seedu.duck.command;

import seedu.duck.setting.SystemSetting;
import seedu.duck.storage.IOManager;

import java.io.IOException;

import static seedu.duck.util.Constant.DEFAULT_PASSWORD;
import static seedu.duck.util.Constant.DEFAULT_USERNAME;

public class ChangeUsernameCommand extends Command {
    public static final String COMMAND_WORD = "name";

    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Change the username.\n"
            + "      Example: "
            + COMMAND_WORD + " duck";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 更改用户名.\n"
            + "      例子: "
            + COMMAND_WORD + " duck";

    private final String username;

    public ChangeUsernameCommand(String username) {
        this.username = username;
        this.promptType = PromptType.INFORMATIVE;
    }

    @Override
    public CommandResult executeInEnglish() {
        SystemSetting.setUsername(username);
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
        SystemSetting.setUsername(username);
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
