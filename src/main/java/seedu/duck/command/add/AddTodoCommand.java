package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.command.PromptType;
import seedu.duck.data.TaskManager;
import seedu.duck.setting.SystemSetting;
import seedu.duck.task.Task;
import seedu.duck.task.TodoTask;

import static seedu.duck.util.Constant.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_ENGLISH;
import static seedu.duck.util.Message.MESSAGE_TODO_SUCCESS_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_TODO_SUCCESS_IN_ENGLISH;

public class AddTodoCommand extends AddCommand {
    private final TodoTask toAdd;
    public static final String COMMAND_WORD = "todo";
    public static final char COMMAND_TYPE = 'T';
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Add a todo task to the DUCK system.\n"
            + "      Example: "
            + "todo return a book";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 添加一个一般任务.\n"
            + "      例子: "
            + "todo 回家看看";

    public AddTodoCommand(Task toAdd) {
        this.toAdd = (TodoTask)toAdd;
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
        if (containsDupTask() && !SystemSetting.isDuplicatedAllowed()){
            return new CommandResult(MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_ENGLISH);
        } else {
            TaskManager.add(toAdd);
            return new CommandResult(String.format(
                    MESSAGE_TODO_SUCCESS_IN_ENGLISH,
                    toAdd.getIndex() + LIST_INDEX_OFFSET,
                    COMMAND_TYPE,
                    toAdd.getChar(),
                    toAdd.getDescription()));
        }
    }

    @Override
    public CommandResult executeInChinese() {
        if (containsDupTask() && !SystemSetting.isDuplicatedAllowed()){
            return new CommandResult(MESSAGE_DUPLICATED_TASK_NOT_ALLOWED_IN_CHINESE);
        } else {
            TaskManager.add(toAdd);
            return new CommandResult(String.format(
                    MESSAGE_TODO_SUCCESS_IN_CHINESE,
                    toAdd.getIndex() + LIST_INDEX_OFFSET,
                    COMMAND_TYPE,
                    toAdd.getChar(),
                    toAdd.getDescription()));
        }
    }

    public boolean containsDupTask(){
        return  (int)TaskManager.getTaskList().stream()
                .filter(task -> task.getType() == toAdd.getType())
                .filter(task -> task.getDescription().equalsIgnoreCase(toAdd.getDescription()))
                .count() != 0;
    }
}
