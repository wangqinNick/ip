package parser;

import command.Command;
import command.DoneCommand;
import command.ExitCommand;
import command.IncorrectCommand;
import command.ListCommand;
import command.add.AddCommand;
import exception.ParseException;
import system.TaskManager;
import task.Task;
import ui.TextUi;
import util.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static util.Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX;

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
        case DoneCommand.COMMAND_WORD:
            return prepareDone(commandWord);
        //list
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        //exit
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        case AddCommand.COMMAND_WORD:
            return prepareAddTask(taskManager, nextTaskIndex, commandWordDescription.trim());
        default:
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
    }

    private Command prepareAddTask(TaskManager taskManager, int nextTaskIndex, String commandDescription) {
        TextUi.printDivider();
        return new AddCommand(new Task(nextTaskIndex, commandDescription));
    }

    private Command prepareDone (String args) {
        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args, DONE_INDEX);
            return new DoneCommand(targetIndex);
        } catch (ParseException pe) {

            return new IncorrectCommand(String.format(Message.MESSAGE_INVALID_COMMAND_FORMAT));
        } catch (NumberFormatException nfe) {

            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        } catch (StringIndexOutOfBoundsException nfe) {

            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }

    private int parseArgsAsDisplayedIndex(String args, int index) throws ParseException, NumberFormatException,
            StringIndexOutOfBoundsException{
        final Matcher matcher = TASK_INDEX_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            throw new ParseException(Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
        if (args.length() < index) {

            throw new StringIndexOutOfBoundsException(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        return Integer.parseInt(args.substring(index));
    }
}
