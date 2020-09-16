package seedu.duck.task;

import seedu.duck.util.DateTime;

public class DeadlineTask extends Task{

    public DeadlineTask() {
    }

    public DeadlineTask(String taskDescription, DateTime taskDeadline) {
        super(taskDescription, TaskType.D);
        //taskDeadlineDate = ParseTime.parseStringToLocalTime(this.taskTime);
    }

    public DeadlineTask(String taskDescription, String taskDeadline) {
        super(taskDescription, TaskType.D);
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
