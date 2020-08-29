package seedu.duck.task;

public class EventTask extends Task{

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

    public String getTaskStartTime() {
        return taskTime;
    }

    public String getTaskEndTime() {
        return taskTime;
    }
}
