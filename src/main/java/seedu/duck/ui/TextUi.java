package seedu.duck.ui;

import seedu.duck.Duck;
import seedu.duck.system.TaskManager;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;
import seedu.duck.task.TodoTask;
import seedu.duck.util.Message;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.ArrayList;

import static org.fusesource.jansi.Ansi.ansi;
import static seedu.duck.util.Message.*;

public class TextUi {
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    public static final int INDEX_OFF_SET = -1;
    public static final int LIST_INDEX_OFFSET = 1;
    private static StringBuilder tasksMessages;
    /**
     * Print all tasks in the duck.task list
     */
    public static String getAppendedTasksMessage(ArrayList<Task> taskListToPrint){
        getTaskListMessage(taskListToPrint);
        return tasksMessages.toString();
    }
    /**
     * get taskList message
     */
    private static void getTaskListMessage(ArrayList<Task> taskListToPrint) {
        tasksMessages = new StringBuilder();
        for (int index = LIST_INDEX_OFFSET; index <= taskListToPrint.size() ; index++) {
            Task task = taskListToPrint.get(index+ INDEX_OFF_SET);
            appendAllTaskMessage(index, task);
        }
    }

    private static void appendAllTaskMessage(int index, Task task) {
        if (task instanceof TodoTask) {
            appendTodoTask((TodoTask) task, index);
        } else if (task instanceof DeadlineTask) {
            appendDeadlineTask((DeadlineTask) task, index);
        } else if( task instanceof EventTask) {
            appendEventTask((EventTask) task, index);
        }
    }


    public static void appendTodoTask(TodoTask todoTask, int index){
        tasksMessages.append(
                String.format(
                    MESSAGE_LIST_RESPOND_FORMAT,
                    String.format(
                        MESSAGE_TODO_LIST,
                        index,
                        todoTask.getType(),
                        todoTask.getChar(),
                        todoTask.getDescription())
                )
        ).append("\n");
    }

    /**
     * print deadline-type task
     * @param deadlineTask deadline task to print
     * @param index index of deadline task
     */
    public static void appendDeadlineTask(DeadlineTask deadlineTask, int index){
        tasksMessages.append(
                String.format(
                    MESSAGE_LIST_RESPOND_FORMAT,
                    String.format(
                        MESSAGE_DEADLINE_LIST,
                        index, deadlineTask.getTaskInformation()))
        ).append("\n");
    }

    /**
     * print event-type task
     * @param eventTask event task to print
     * @param index index of event task
     */
    public static void appendEventTask(EventTask eventTask, int index){
        tasksMessages.append(
                String.format(MESSAGE_LIST_RESPOND_FORMAT,
                    String.format(
                        MESSAGE_EVENT_LIST,
                        index, eventTask.getTaskInformation()))
        ).append("\n");
    }
}

