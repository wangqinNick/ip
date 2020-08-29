package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.system.TaskManager;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.Task;

import static seedu.duck.ui.TextUi.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_DEADLINE_SUCCESS;

public class AddDeadlineCommand extends AddCommand {

    public static final String COMMAND_WORD = "deadline";
    public static final char COMMAND_TYPE = 'D';
    public static final String MESSAGE_USAGE_1 = COMMAND_WORD + ": Add a Deadline task to the DUKE system.";
    public static final String MESSAGE_USAGE_2 = "      Example: " + COMMAND_WORD+ " read a book";
    private final DeadlineTask deadlineTask;

    public AddDeadlineCommand(Task deadlineTask) {
        this.deadlineTask = (DeadlineTask) deadlineTask;
    }

    @Override
    public CommandResult execute() {
        if (deadlineTask == null) {
            return new CommandResult("Invalid Command Format");
        }
        TaskManager.add(deadlineTask);
        //according to the data format
        return new CommandResult(
                String.format(
                    MESSAGE_DEADLINE_SUCCESS ,
                    deadlineTask.getIndex() + LIST_INDEX_OFFSET,
                    COMMAND_TYPE,
                    deadlineTask.getChar(),
                    deadlineTask.getDescription(),
                    deadlineTask.getTaskDeadline()));
    }
}
