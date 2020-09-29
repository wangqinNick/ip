package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.data.TaskManager;
import seedu.duck.setting.SystemSetting;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;

import static seedu.duck.util.Constant.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_EVENT_SUCCESS_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_EVENT_SUCCESS_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_INVALID_COMMAND_FORMAT_IN_CHINESE;

public class AddEventCommand extends AddCommand {

    public static final String COMMAND_WORD = "event";
    public static final char COMMAND_TYPE = 'E';
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Add a event task to the DUCK system.\n"
            + "      Example: "
            + "event return book /at 2-12-2019";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 添加一个带有开始日期的任务.\n"
            + "      例子: "
            + "event 电影节 /at 2-12-2019";

    private final EventTask eventTask;

    public AddEventCommand(Task eventTask) {
        this.eventTask = (EventTask) eventTask;
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
        if (eventTask == null) {
            return new CommandResult(MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH);
        }
        if (containsDupTask() && SystemSetting.isDuplicatedAllowed()){
            return new CommandResult(MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_ENGLISH);
        } else {
            TaskManager.add(eventTask);
            if (eventTask.getTaskDate() != null) {
                return new CommandResult(
                        String.format(
                                MESSAGE_EVENT_SUCCESS_IN_ENGLISH,
                                eventTask.getIndex() + LIST_INDEX_OFFSET,
                                COMMAND_TYPE,
                                eventTask.getChar(),
                                eventTask.getDescription(),
                                eventTask.getTaskDate().toString()));
            }
            return new CommandResult(
                    String.format(
                            MESSAGE_EVENT_SUCCESS_IN_ENGLISH,
                            eventTask.getIndex() + LIST_INDEX_OFFSET,
                            COMMAND_TYPE,
                            eventTask.getChar(),
                            eventTask.getDescription(),
                            eventTask.getTaskDateInString()));
        }
    }

    @Override
    public CommandResult executeInChinese() {
        if (eventTask == null) {
            return new CommandResult(MESSAGE_INVALID_COMMAND_FORMAT_IN_CHINESE);
        }
        if (containsDupTask() && SystemSetting.isDuplicatedAllowed()){
            return new CommandResult(MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE);
        } else {
            TaskManager.add(eventTask);
            if (eventTask.getTaskDate() != null) {
                return new CommandResult(
                        String.format(
                                MESSAGE_EVENT_SUCCESS_IN_CHINESE,
                                eventTask.getIndex() + LIST_INDEX_OFFSET,
                                COMMAND_TYPE,
                                eventTask.getChar(),
                                eventTask.getDescription(),
                                eventTask.getTaskDate().toString()));
            }
            return new CommandResult(
                    String.format(
                            MESSAGE_EVENT_SUCCESS_IN_CHINESE,
                            eventTask.getIndex() + LIST_INDEX_OFFSET,
                            COMMAND_TYPE,
                            eventTask.getChar(),
                            eventTask.getDescription(),
                            eventTask.getTaskDateInString()));
        }
    }

    public boolean containsDupTask(){
        return  (int)TaskManager.getTaskList().stream()
                .filter(task -> task.getType() == eventTask.getType())
                .filter(task -> task.getDescription().equalsIgnoreCase(eventTask.getDescription()))
                .count() != 0;
    }
}
