package task;

public class Task {

    protected int index;
    protected String description;

    public Task() {
    }

    public Task(int index, String description) {
        this.index = index;
        this.description = description;
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
