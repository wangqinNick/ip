package seedu.duck.task;

import seedu.duck.util.DateTime;

public class DeadlineTask extends Task{

    public DeadlineTask() {
    }

    public DeadlineTask(String taskDescription, DateTime taskDeadline) {
        this(taskDescription, taskDeadline, false);
    }

    public DeadlineTask(String taskDescription, DateTime taskDeadline, boolean isDone) {
        super(taskDescription, TaskType.D, isDone);
        this.taskDate = taskDeadline;
    }

    public DeadlineTask(String taskDescription, String taskDeadline) {
        this(taskDescription, taskDeadline, false);
    }

    public DeadlineTask(String taskDescription, String taskDeadline, boolean isDone) {
        super(taskDescription, TaskType.D, isDone);
        this.taskDateInString = taskDeadline;
    }

    public String getTaskDeadlineInString() {
        return taskDateInString;
    }

    /**
     * get the task information in a String
     * @return a string taskInformation contains all essential information for the deadline task
     */
    public String getTaskInformation() {

        if (taskDate!=null){
            var timeString = taskDate.getDate();
            return String.format("[%c][%c] %s (%s)",
                    getType(),
                    getChar(),
                    description,
                    timeString);
        } else {
            return String.format(
                    "[%c][%c] %s (%s)",
                    getType(),
                    getChar(),
                    description,
                    taskDateInString);
        }
    }
}
