package seedu.duck.command;

import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;

import java.util.ArrayList;

import static seedu.duck.ui.TextUi.*;

public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Find all tasks matches the given description.\n"
            + "      Example: "
            + "find book";

    public static final String MESSAGE_EMPTY_LIST = "Can not find any task description "
            +"contains this keyword";

    protected String toSearch;
    protected ArrayList<Task> filteredTaskList;

    public FindCommand() {

    }

    public FindCommand(String commandDescription) {
        this.toSearch = commandDescription;
        this.promptType = PromptType.NONE;
    }

    @Override
    public CommandResult execute() {
        filteredTaskList = TaskManager.searchTask(toSearch);
        if (filteredTaskList.isEmpty()) return new CommandResult(MESSAGE_EMPTY_LIST);
        String taskListMessage = getAppendedTasksMessage(filteredTaskList);
        return new CommandResult(taskListMessage);
    }
}
