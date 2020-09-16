package seedu.duck.task;

import seedu.duck.parser.ParseTime;
import seedu.duck.util.DateTime;
import seedu.duck.util.DateTimeFormat;
import seedu.duck.util.Month;

import java.time.LocalDate;

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

    public DateTime getTaskDeadline() {
        return taskDate;
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
