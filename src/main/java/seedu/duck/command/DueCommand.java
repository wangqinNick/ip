package seedu.duck.command;

import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;
import seedu.duck.task.Timeliness;
import seedu.duck.util.DateTime;

import java.time.LocalDate;
import java.util.ArrayList;

import static seedu.duck.ui.TextUi.getAppendedTasksMessage;
import static seedu.duck.util.Message.MESSAGE_EMPTY_LIST;

public class DueCommand extends Command{

    public static final String COMMAND_WORD = "due";
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
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task task : TaskManager.getTaskList()) {
            if (task instanceof Timeliness){
                DateTime dateTime = new DateTime(((Timeliness) task).getDate());
                if (dateTime.getDate() != null && dateTime.isOn(searchDate)) {
                    filteredTasks.add(task);
                }
            }
        }
        return filteredTasks;
    }

    @Override
    public CommandResult execute() {
        ArrayList<Task> filteredTasks = filterDate();
        if (filteredTasks.isEmpty()) {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }
        var listMessage = getAppendedTasksMessage(filteredTasks);
        return new CommandResult((listMessage));
    }
}
