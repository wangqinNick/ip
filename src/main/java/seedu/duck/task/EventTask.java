package seedu.duck.task;

import seedu.duck.util.DateTime;

public class EventTask extends Task {

    public EventTask() {
    }

    public EventTask(String taskDescription, DateTime taskStartTime) {
        super(taskDescription, TaskType.E);
        this.taskDate = taskStartTime;
        //taskDeadlineDate = ParseTime.parseStringToLocalTime(this.taskTime);
    }

    public EventTask(String taskDescription, String taskDeadline) {
        super(taskDescription, TaskType.E);
        this.taskDateInString = taskDeadline;
    }

    /**
     * get the task information
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
