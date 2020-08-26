package command;


import system.TaskManager;

public abstract class Command {
    public String COMMAND_WORD;

    public Command() {
    }

    public abstract CommandResult execute () ;
}
