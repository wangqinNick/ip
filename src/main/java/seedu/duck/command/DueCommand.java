package seedu.duck.command;

import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;
import seedu.duck.task.Timeliness;
import seedu.duck.util.DateTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static seedu.duck.ui.TextUi.getAppendedTasksMessage;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST_IN_CHINESE;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST_IN_ENGLISH;

public class DueCommand extends Command{

    public static final String COMMAND_WORD = "due";
    public static final String MESSAGE_USAGE_IN_ENGLISH = COMMAND_WORD
            + ": Find tasks on a specific date.\n"
            + "      Example: "
            + "due 2-12-2019";

    public static final String MESSAGE_USAGE_IN_CHINESE = COMMAND_WORD
            + ": 找出指定日期的所有任务.\n"
            + "      例子: "
            + "due 2-12-2019";

    private LocalDate searchDate;

    /**
     * Constructs the <b>Due Command</b>.
     * <br> If the <code>specifier</code> given is <code>NULL</code>, the <code>timeSpecifier</code> is set to
     * <i>on</i>.
     * @param searchDate
     *  The <i>date</i> to filter the <b>Task List</b> by
     */
    public DueCommand(LocalDate searchDate) {
        this.searchDate = searchDate;
        this.promptType = PromptType.NONE;

    }

    /**
     * Filters the <i>tasks</i> for <i>deadlines</i> on the <u>same</u> <i>date</i> as the specified search date.
     * <br> Returns an <code>ArrayList</code> containing the filtered <i>tasks</i>.
     * @return
     *  The <code>ArrayList</code> of filtered tasks
     */
    private ArrayList<Task> filterDate() {
        return (ArrayList<Task>) TaskManager.getTaskList().stream()
                .filter((t) -> t instanceof Timeliness)
                .filter((t) -> {
                    new DateTime(((Timeliness) t).getDate());
                    return true;
                })
                .filter((t) -> new DateTime(((Timeliness) t).getDate()).isOn(searchDate))
                .collect(Collectors.toList());
    }

    /**
     * Executes the command
     * Returns the command result
     *
     * @return the command result
     */
    @Override
    public CommandResult executeInEnglish() {
        var filteredTasks = filterDate();
        if (filteredTasks.isEmpty()) {
            return new CommandResult(MESSAGE_EMPTY_LIST_IN_ENGLISH);
        }
        var listMessage = getAppendedTasksMessage(filteredTasks);
        return new CommandResult((listMessage));
    }

    @Override
    public CommandResult executeInChinese() {
        var filteredTasks = filterDate();
        if (filteredTasks.isEmpty()) {
            return new CommandResult(MESSAGE_EMPTY_LIST_IN_CHINESE);
        }
        var listMessage = getAppendedTasksMessage(filteredTasks);
        return new CommandResult((listMessage));
    }
}
