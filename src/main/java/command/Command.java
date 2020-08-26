package command;


import system.TaskManager;

public abstract class Command {
    public String COMMAND_WORD;
    protected TaskManager taskManager;

    public Command() {
    }

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public abstract CommandResult execute () ;
}
