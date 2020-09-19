package seedu.duck.task;

import java.time.LocalDate;

public class EventTask extends Task implements Timeliness{

    public EventTask() {
    }

    public EventTask(String taskDescription, LocalDate taskStartTime) {
        this(taskDescription, taskStartTime, false);
    }

    public EventTask(String taskDescription, LocalDate taskStartTime, boolean isDone) {
        super(taskDescription, TaskType.E, isDone);
        this.taskDate = taskStartTime;
    }

    public EventTask(String taskDescription, String taskDeadline) {
        this(taskDescription, taskDeadline, false);
    }

    public EventTask(String taskDescription, String taskDeadline, boolean isDone) {
        super(taskDescription, TaskType.E, isDone);
        this.taskDateInString = taskDeadline;
    }

    /**
     * get the task information
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

    @Override
    public LocalDate getDate() {
        if (taskDate!=null){
            return taskDate;
        } else {
            return null;
        }
    }
}
