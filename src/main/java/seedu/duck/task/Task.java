package seedu.duck.task;

import seedu.duck.system.TaskManager;
import seedu.duck.util.Message;

public class Task {

    protected int index;
    protected String description;
    protected boolean isDone;

    public Task() {
    }

    public Task(String description) {
        this.index = TaskManager.size();
        this.description = description;
        this.isDone = false;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public char getChar(){
        char isDone;
        if (this.isDone){
            return Message.DONE;
        } else {
            return Message.NOTDONE;
        }
    }

    public boolean isSameTask(String taskDescription) {
        return this.description.equals(taskDescription);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
