package seedu.duck.task;

import seedu.duck.parser.ParseTime;
import seedu.duck.util.Month;

import java.time.LocalDate;

public class DeadlineTask extends Task{
    protected String taskInformation;
    public DeadlineTask() {
    }

    public DeadlineTask(String taskDescription, String taskDeadline) {
        super(taskDescription, TaskType.D);
        this.taskTime = taskDeadline;
        taskDeadlineDate = ParseTime.parseStringToLocalTime(this.taskTime);
    }

    public String getTaskDeadline() {
        return taskTime;
    }

    public LocalDate getTaskDeadlineDate() {
        return taskDeadlineDate;
    }

    /*
     *  returns a string taskInformation contains all essential information for the deadline task
     */
    public String getTaskInformation() {
        if (taskDeadlineDate!=null){
            String timeString = String.format("%s %s %s",
                    Month.valueOf(taskDeadlineDate.getMonthValue()),
                    taskDeadlineDate.getDayOfMonth(),
                    taskDeadlineDate.getYear());
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
                    getTaskDeadline());
        }
        return taskInformation;
    }
}
