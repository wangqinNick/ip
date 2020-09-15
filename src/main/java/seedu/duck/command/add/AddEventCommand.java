package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.system.TaskManager;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;

import static seedu.duck.ui.TextUi.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_EVENT_SUCCESS;

public class AddEventCommand extends AddCommand {

    public static final String COMMAND_WORD = "event";
    public static final char COMMAND_TYPE = 'E';
    public static final String MESSAGE_USAGE_1 = COMMAND_WORD + ": Add a Event task to the DUKE system.";
    public static final String MESSAGE_USAGE_2 = "    Example: " + COMMAND_WORD+ " read a book";


    private final EventTask eventTask;

    public AddEventCommand(Task eventTask) {
        this.eventTask = (EventTask) eventTask;
    }

    @Override
    public CommandResult execute() {
        if (eventTask == null) {
            return new CommandResult("Invalid Command Format");
        }
        TaskManager.add(eventTask);
        return new CommandResult(
                String.format(
                    MESSAGE_EVENT_SUCCESS,
                    eventTask.getIndex() + LIST_INDEX_OFFSET,
                    COMMAND_TYPE,
                    eventTask.getChar(),
                    eventTask.getDescription(),
                    eventTask.getTime()));
    }
}
