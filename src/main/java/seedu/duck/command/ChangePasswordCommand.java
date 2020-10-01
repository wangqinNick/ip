package seedu.duck.command;

import seedu.duck.setting.SystemSetting;
import seedu.duck.storage.IOManager;

import java.io.IOException;

import static seedu.duck.util.Constant.DEFAULT_PASSWORD;
import static seedu.duck.util.Constant.DEFAULT_USERNAME;
import static seedu.duck.util.Message.MESSAGE_CHANGE_USER_INFO_FAILED_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_CHANGE_USER_INFO_FAILED_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_CHANGE_USER_INFO_SUCCESS_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_CHANGE_USER_INFO_SUCCESS_IN_ENGLISH;

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
            return new CommandResult(MESSAGE_CHANGE_USER_INFO_FAILED_IN_ENGLISH);
        }
        return new CommandResult(MESSAGE_CHANGE_USER_INFO_SUCCESS_IN_ENGLISH);
    }

    @Override
    public CommandResult executeInChinese() {
        SystemSetting.setPassword(password);
        try {
            IOManager.saveUserInfo();
        } catch (IOException ioe){
            SystemSetting.setUsername(DEFAULT_USERNAME);
            SystemSetting.setPassword(DEFAULT_PASSWORD);
            return new CommandResult(MESSAGE_CHANGE_USER_INFO_FAILED_IN_CHINESE);
        }
        return new CommandResult(MESSAGE_CHANGE_USER_INFO_SUCCESS_IN_CHINESE);
    }
}
