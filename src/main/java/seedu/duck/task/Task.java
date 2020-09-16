package seedu.duck.task;

import seedu.duck.system.TaskManager;
import seedu.duck.util.DateTime;
import seedu.duck.util.Message;
import static seedu.duck.util.Constant.DEFAULT_TASK_TIME;

public class Task {

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

    /**
     * set the task status to Done
     * @param done done
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * get the status of the task: Done, not Done
     * @return the status of the task
     */
    public char getChar(){
        if (this.isDone){
            return Message.DONE;
        } else {
            return Message.NOT_DONE;
        }
    }

    /**
     * get the task type: D, E, T
     * @return task type
     */
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

    /**
     * compare if two tasks have same task description
     * @param taskDescription task description
     * @return true, if same; false, if different
     */
    public boolean isSameTask(String taskDescription) {
        return this.description.equals(taskDescription);
    }

    /**
     * get the task index
     * @return task index
     */
    public int getIndex() {
        return index;
    }

    /**
     * get the task description
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * get the date in String
     * @return the date in String
     */
    public String getTaskDateInString() {
        return taskDateInString;
    }

    /**
     * get the date in DateTime
     * @return the date in DateTime
     */
    public DateTime getTaskDate() {
        return taskDate;
    }
}
