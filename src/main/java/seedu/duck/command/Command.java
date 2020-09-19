package seedu.duck.command;


import seedu.duck.data.TaskManager;
import seedu.duck.task.Task;

import static seedu.duck.command.PromptType.NONE;
import static seedu.duck.util.Constant.INDEX_OFF_SET;

public abstract class Command {
    protected TaskManager taskManager;
    protected PromptType promptType = NONE;
    private int targetIndex = -1;

    public Command() {
    }

    /**
     * @param targetIndex last visible listing index of the target person
     */
    public Command(int targetIndex) {
        this.targetIndex = targetIndex;
    }

    /**
     * Supplies the data the duck.command will operate on.
     */
    public void setData(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    /**
     * Extracts the the target person in the last shown list from the given arguments.
     *
     * @throws IndexOutOfBoundsException if the target index is out of bounds of the last viewed listing
     */
    protected Task getTargetTask() throws IndexOutOfBoundsException {
        return TaskManager.getTaskList().get(getTargetIndex() - INDEX_OFF_SET);
    }

    /**
     * get target index
     * @return targetIndex
     */
    public int getTargetIndex() {
        return targetIndex;
    }

    public PromptType getPromptType() {
        return promptType;
    }

    public void setPromptType(PromptType promptType) {
        this.promptType = promptType;
    }

    public abstract CommandResult execute () ;
}
