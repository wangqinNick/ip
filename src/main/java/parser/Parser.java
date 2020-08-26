package parser;

import command.Command;
import command.ExitCommand;
import command.ListCommand;
import command.add.AddCommand;
import system.TaskManager;
import task.Task;
import ui.TextUi;

import java.util.regex.Pattern;

public class Parser {
    public static final Pattern TASK_INDEX_ARGS_FORMAT = Pattern.compile("(?<targetIndex>.+)");
    public static final String DATE_SPLITTER = "/";
    public static final String COMMAND_SPLITTER = " ";
    public static final char CAP_ACKNOWLEDGEMENT = 'Y';
    public static final char ACKNOWLEDGEMENT = 'y';
    /** index suffix for done and delete command */
    public static final int DELETE_INDEX = 7;
    public static final int DONE_INDEX = 5;
    public static final int USER_CHOICE_INDEX = 0;
    public static final int DESCRIPTION_MAXIMUM_SECTIONS = 2;
    public static final int DESCRIPTION_INDEX = 0;
    public static final int TIME_INDEX = 1;
    public static final int COMMAND_WORD_INDEX = 0;

    public Command parseCommand(TaskManager taskManager, String userInput) {
        final String commandWord = userInput;
        final String []commandWordFirstPart = commandWord.split(COMMAND_SPLITTER);
        /** further split the user input, get the secondary part, the description */
        final String commandWordDescription = commandWord.substring(commandWordFirstPart[COMMAND_WORD_INDEX].length());
        //operates according to different command word
        return getCommand(taskManager, taskManager.getTaskList().size(), commandWord, commandWordFirstPart, commandWordDescription);
    }

    /**
     * @param commandWordFirstPart, commandWordDescription the input String spited parts
     * @return parsed command
     */
    private Command getCommand(TaskManager taskManager, int nextTaskIndex, String commandWord, String[] commandWordFirstPart, String commandWordDescription) {
        switch (commandWordFirstPart[COMMAND_WORD_INDEX]){
        //list
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        //exit
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        default:
            return prepareAddTask(taskManager, nextTaskIndex, commandWordDescription.trim());
        }
    }

    private Command prepareAddTask(TaskManager taskManager, int nextTaskIndex, String commandDescription) {
        TextUi.printDivider();
        return new AddCommand(new Task(nextTaskIndex, commandDescription));
    }
}
