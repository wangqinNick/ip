package seedu.duck.ui;

import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;
import seedu.duck.task.TodoTask;
import java.util.ArrayList;

import static seedu.duck.util.Constant.INDEX_OFF_SET;
import static seedu.duck.util.Constant.LIST_INDEX_OFFSET;
import static seedu.duck.util.Constant.NEWLINE;
import static seedu.duck.util.Message.MESSAGE_DEADLINE_LIST;
import static seedu.duck.util.Message.MESSAGE_EVENT_LIST;
import static seedu.duck.util.Message.MESSAGE_LIST_RESPOND_FORMAT;
import static seedu.duck.util.Message.MESSAGE_TODO_LIST;


public class TextUi {
    private static StringBuilder tasksMessages;

    /**
     * Return the message of all tasks in a specific task list
     * @param taskListToPrint the specific task list
     * @return the appended task message
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

    /**
     * append all tasks message
     * @param index index of the task
     * @param task the task to append message
     */
    private static void appendAllTaskMessage(int index, Task task) {
        if (task instanceof TodoTask) {
            appendTodoTask((TodoTask) task, index);
        } else if (task instanceof DeadlineTask) {
            appendDeadlineTask((DeadlineTask) task, index);
        } else if( task instanceof EventTask) {
            appendEventTask((EventTask) task, index);
        }
    }

    /**
     * append a 'To-do' type task message
     * @param todoTask the task
     * @param index the index of the task
     */
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
        ).append(NEWLINE);
    }

    /**
     * append a 'deadline' type task message
     * @param deadlineTask the task
     * @param index the index of the task
     */
    public static void appendDeadlineTask(DeadlineTask deadlineTask, int index){
        tasksMessages.append(
                String.format(
                    MESSAGE_LIST_RESPOND_FORMAT,
                    String.format(
                        MESSAGE_DEADLINE_LIST,
                        index,
                        deadlineTask.getTaskInformation()))
        ).append(NEWLINE);
    }

    /**
     * append a 'event' type task message
     * @param eventTask the task
     * @param index the index of the task
     */
    public static void appendEventTask(EventTask eventTask, int index){
        tasksMessages.append(
                String.format(MESSAGE_LIST_RESPOND_FORMAT,
                    String.format(
                        MESSAGE_EVENT_LIST,
                        index,
                        eventTask.getTaskInformation()))
        ).append(NEWLINE);
    }
}

