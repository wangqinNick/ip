package seedu.duck.task;

public class EventTask extends Task implements Timeliness{

    public EventTask() {
    }

    @Override
    public String getTaskInformation() {
        return null;
    }

    public EventTask(String description, String taskStartTime) {
        super(description, TaskType.E);
        this.taskTime = taskStartTime;
    }

    @Override
    public String getTime() {
        return taskTime;
    }
}
