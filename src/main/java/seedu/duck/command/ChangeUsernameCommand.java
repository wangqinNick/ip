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
            return new CommandResult(MESSAGE_CHANGE_USER_INFO_FAILED_IN_ENGLISH);
        }
        return new CommandResult(MESSAGE_CHANGE_USER_INFO_SUCCESS_IN_ENGLISH);
    }

    @Override
    public CommandResult executeInChinese() {
        SystemSetting.setUsername(username);
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
