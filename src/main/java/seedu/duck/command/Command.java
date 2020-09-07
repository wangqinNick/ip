package seedu.duck.command;


import seedu.duck.system.TaskManager;
import seedu.duck.task.Task;
import seedu.duck.ui.TextUi;

public abstract class Command {
    public String COMMAND_WORD;
    protected TaskManager taskManager;
    private int targetIndex = -1;

    public Command() {
    }

    /**
     * @param targetIndex last visible listing index of the target person
     */
    public Command(int targetIndex) {
        this.setTargetIndex(targetIndex);
    }

    public void setTargetIndex(int targetIndex) {
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
        return TaskManager.getTaskList().get(getTargetIndex() - TextUi.DISPLAYED_INDEX_OFFSET);
    }

    /**
     * get target index
     * @return targetIndex
     */
    public int getTargetIndex() {
        return targetIndex;
    }

    public abstract CommandResult execute () ;
}
