package seedu.duck.task;

import seedu.duck.util.DateTime;

public class EventTask extends Task {

    private DateTime taskStartTime;
    public EventTask() {
    }

    public EventTask(String taskDescription, DateTime taskStartTime) {
        super(taskDescription, TaskType.E);
        this.taskStartTime = taskStartTime;
        //taskDeadlineDate = ParseTime.parseStringToLocalTime(this.taskTime);
    }

    public EventTask(String taskDescription, String taskDeadline) {
        super(taskDescription, TaskType.E);
        this.taskDateInString = taskDeadline;
    }

    public String getTimeInString() {
        return taskDateInString;
    }
    public DateTime getTimeInDateTime() {
        return taskStartTime;
    }

    /*
     *  returns a string taskInformation contains all essential information for the deadline task
     */
    public String getTaskInformation() {
        String taskInformation;
        if (taskDate!=null){
            String timeString = taskDate.getDate();
            taskInformation = String.format("[%c][%c] %s (%s)",
                    getType(),
                    getChar(),
                    description,
                    timeString);
        } else {
            taskInformation = String.format(
                    "[%c][%c] %s (%s)",
                    getType(),
                    getChar(),
                    description,
                    taskDateInString);
        }
        return taskInformation;
    }

}
