package seedu.duck.command;

import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;

import java.util.ArrayList;

import static seedu.duck.ui.TextUi.*;

public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Find all tasks matches the given description.\n"
            + "      Example: "
            + "find book";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 找出包含指定关键字的所有任务.\n"
            + "      例子: "
            + "find 书";

    public static final String MESSAGE_EMPTY_LIST = "Can not find any task description "
            +"contains this keyword";

    public static final String MESSAGE_EMPTY_LIST_IN_CHINESE = "找不到包含此关键词的任务";


    protected String toSearch;
    protected ArrayList<Task> filteredTaskList;

    public FindCommand(String commandDescription) {
        this.toSearch = commandDescription;
        this.promptType = PromptType.NONE;
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        filteredTaskList = TaskManager.searchTask(toSearch);
        if (filteredTaskList.isEmpty()) return new CommandResult(MESSAGE_EMPTY_LIST);
        var taskListMessage = getAppendedTasksMessage(filteredTaskList);
        return new CommandResult(taskListMessage);
    }

    @Override
    public CommandResult executeInChinese() {
        filteredTaskList = TaskManager.searchTask(toSearch);
        if (filteredTaskList.isEmpty()) return new CommandResult(MESSAGE_EMPTY_LIST_IN_CHINESE);
        var taskListMessage = getAppendedTasksMessage(filteredTaskList);
        return new CommandResult(taskListMessage);
    }
}
