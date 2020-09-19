package seedu.duck.task;

import java.time.LocalDate;

public class DeadlineTask extends Task implements Timeliness{

    public DeadlineTask() {
    }

    public DeadlineTask(String taskDescription, LocalDate taskDeadline) {
        this(taskDescription, taskDeadline, false);
    }

    public DeadlineTask(String taskDescription, LocalDate taskDeadline, boolean isDone) {
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
     * Return the task information in a String
     * @return a string taskInformation contains all essential information for the deadline task
     */
    public String getTaskInformation() {

        if (taskDate!=null){
            var timeString = taskDate.toString();
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

    /**
     * Return the task date
     * @return task date
     */
    @Override
    public LocalDate getDate() {
        if (taskDate!=null){
            return taskDate;
        } else {
            return null;
        }
    }
}
