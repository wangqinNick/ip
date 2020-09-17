package seedu.duck.command.add;

import seedu.duck.command.CommandResult;
import seedu.duck.system.TaskManager;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;

import static seedu.duck.util.Constant.LIST_INDEX_OFFSET;
import static seedu.duck.util.Message.MESSAGE_DEADLINE_SUCCESS;
import static seedu.duck.util.Message.MESSAGE_EVENT_SUCCESS;

public class AddEventCommand extends AddCommand {

    public static final String COMMAND_WORD = "event";
    public static final char COMMAND_TYPE = 'E';
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Add a event task to the DUCK system.\n"
            + "      Example: "
            + "event return book /at 2/12/2019 1800";


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
        if (eventTask.getTaskDate()!=null){
            return new CommandResult(
                    String.format(
                            MESSAGE_DEADLINE_SUCCESS ,
                            eventTask.getIndex() + LIST_INDEX_OFFSET,
                            COMMAND_TYPE,
                            eventTask.getChar(),
                            eventTask.getDescription(),
                            eventTask.getTaskDate().getDate()));
        }
        return new CommandResult(
                String.format(
                    MESSAGE_EVENT_SUCCESS,
                    eventTask.getIndex() + LIST_INDEX_OFFSET,
                    COMMAND_TYPE,
                    eventTask.getChar(),
                    eventTask.getDescription(),
                    eventTask.getTaskDateInString()));
    }
}
