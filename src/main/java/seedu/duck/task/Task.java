package seedu.duck.task;

import seedu.duck.data.TaskManager;
import seedu.duck.util.Message;

import java.time.LocalDate;

import static seedu.duck.util.Constant.DEFAULT_TASK_TIME;

public class Task {

    protected int index;
    protected String description;
    protected boolean isDone;
    protected TaskType type;
    protected String taskDateInString;
    protected LocalDate taskDate;

    public Task() {
    }

    /**
     * Constructor called by non-type task
     * @param description Task description
     */
    public Task(String description) {
        this.index = TaskManager.getNextIndex();
        this.description = description;
        this.isDone = false;
    }

    public Task(String taskDescription, TaskType taskType, boolean isDone) {
        this.index = TaskManager.getNextIndex();
        this.description = taskDescription;
        this.type = taskType;
        this.isDone = isDone;
        this.taskDateInString = DEFAULT_TASK_TIME;
        this.taskDate = null;
    }

    /**
     * set the task status to Done
     */
    public void setDone() {
        isDone = true;
    }

    /**
     * Return the done status of the task
     * @return done status
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Return the status of the task: Done, not Done
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
     * Return the task type: D, E, T
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
     * Return true, if two tasks have same task description
     * @param taskDescription task description
     * @return true, if same; false, if different
     */
    public boolean isSameTask(String taskDescription) {
        return this.description.equals(taskDescription);
    }

    /**
     * Return the task index
     * @return task index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Return the task description
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the date in String
     * @return the date in String
     */
    public String getTaskDateInString() {
        return taskDateInString;
    }

    /**
     * Return the date in DateTime
     * @return the date in DateTime
     */
    public LocalDate getTaskDate() {
        return taskDate;
    }

}
