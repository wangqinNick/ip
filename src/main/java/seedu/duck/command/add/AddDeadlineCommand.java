package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.data.TaskManager;
import seedu.duck.setting.SystemSetting;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.Task;

import static seedu.duck.util.Constant.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_DEADLINE_SUCCESS_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_DEADLINE_SUCCESS_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_INVALID_COMMAND_IN_CHINESE;

public class AddDeadlineCommand extends AddCommand {

    public static final String COMMAND_WORD = "deadline";
    public static final char COMMAND_TYPE = 'D';
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Add a Deadline task to the DUCK system.\n"
            + "      Example: "
            + "deadline return book /by 2-12-2019";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 添加一个带有截止日期的任务.\n"
            + "      例子: "
            + "deadline 还书 /by 2-12-2019";

    private final DeadlineTask deadlineTask;

    public AddDeadlineCommand(Task deadlineTask) {
        this.deadlineTask = (DeadlineTask) deadlineTask;
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
        if (deadlineTask == null) {
            return new CommandResult(MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH);
        }
        if (containsDupTask() && !SystemSetting.isDuplicatedAllowed()){
            return new CommandResult(MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE);
        } else {
            TaskManager.add(deadlineTask);
            //according to the data format
            if (deadlineTask.getTaskDate() != null) {
                return new CommandResult(
                        String.format(
                                MESSAGE_DEADLINE_SUCCESS_IN_ENGLISH,
                                deadlineTask.getIndex() + LIST_INDEX_OFFSET,
                                COMMAND_TYPE,
                                deadlineTask.getChar(),
                                deadlineTask.getDescription(),
                                deadlineTask.getTaskDate().toString()));
            }
            return new CommandResult(
                    String.format(
                            MESSAGE_DEADLINE_SUCCESS_IN_ENGLISH,
                            deadlineTask.getIndex() + LIST_INDEX_OFFSET,
                            COMMAND_TYPE,
                            deadlineTask.getChar(),
                            deadlineTask.getDescription(),
                            deadlineTask.getTaskDeadlineInString()));
        }
    }

    @Override
    public CommandResult executeInChinese() {
        if (deadlineTask == null) {
            return new CommandResult(MESSAGE_INVALID_COMMAND_IN_CHINESE);
        }
        if (containsDupTask() && !SystemSetting.isDuplicatedAllowed()){
            return new CommandResult(MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE);
        } else {
            TaskManager.add(deadlineTask);
            //according to the data format
            if (deadlineTask.getTaskDate() != null) {
                return new CommandResult(
                        String.format(
                                MESSAGE_DEADLINE_SUCCESS_IN_CHINESE,
                                deadlineTask.getIndex() + LIST_INDEX_OFFSET,
                                COMMAND_TYPE,
                                deadlineTask.getChar(),
                                deadlineTask.getDescription(),
                                deadlineTask.getTaskDate().toString()));
            }
            return new CommandResult(
                    String.format(
                            MESSAGE_DEADLINE_SUCCESS_IN_CHINESE,
                            deadlineTask.getIndex() + LIST_INDEX_OFFSET,
                            COMMAND_TYPE,
                            deadlineTask.getChar(),
                            deadlineTask.getDescription(),
                            deadlineTask.getTaskDeadlineInString()));
        }
    }

    public boolean containsDupTask(){
        return  (int)TaskManager.getTaskList().stream()
                .filter(task -> task.getType() == deadlineTask.getType())
                .filter(task -> task.getDescription().equalsIgnoreCase(deadlineTask.getDescription()))
                .count() != 0;
    }
}
