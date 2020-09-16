package seedu.duck.task;

import seedu.duck.system.TaskManager;
import seedu.duck.util.DateTime;
import seedu.duck.util.Message;

import java.time.LocalDate;

public class Task {

    public static final String DEFAULT_TASK_TIME = "-1";
    protected int index;
    protected String description;
    protected boolean isDone;
    protected TaskType type;
    /** deadline and event task attributes*/
    protected String taskDateInString;
    /** deadline task attributes*/
    protected DateTime taskDate;

    public Task() {
    }

    /**
     * Constructor called by non-type task
     * @param description Task description
     */
    public Task(String description) {
        this.index = TaskManager.size();
        this.description = description;
        this.isDone = false;
    }

    public Task(String taskDescription, TaskType taskType) {
        this.index = TaskManager.size();
        this.description = taskDescription;
        this.type = taskType;
        this.isDone = false;
        this.taskDateInString = DEFAULT_TASK_TIME;
        this.taskDate = null;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public char getChar(){
        if (this.isDone){
            return Message.DONE;
        } else {
            return Message.NOT_DONE;
        }
    }

    public char getType() {
        switch (type){
        case D:
            return 'D';
        case E:
            return 'E';
        case T:
            return 'T';
        default:
            return ' ';
        }
    }

    public boolean isSameTask(String taskDescription) {
        return this.description.equals(taskDescription);
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskDateInString() {
        return taskDateInString;
    }

    public DateTime getTaskDate() {
        return taskDate;
    }
}
