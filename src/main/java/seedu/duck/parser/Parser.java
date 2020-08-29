package seedu.duck.parser;

import seedu.duck.command.Command;
import seedu.duck.command.DoneCommand;
import seedu.duck.command.ExitCommand;
import seedu.duck.command.IncorrectCommand;
import seedu.duck.command.ListCommand;
import seedu.duck.command.add.AddCommand;
import seedu.duck.exception.ParseException;
import seedu.duck.Duck;
import seedu.duck.system.TaskManager;
import seedu.duck.task.Task;
import seedu.duck.util.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duck.util.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.duck.util.Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX;

/**
 *  Parser the String to a Command object
 */
public class Parser {
    public static final Pattern TASK_INDEX_ARGS_FORMAT = Pattern.compile("(?<targetIndex>.+)");
    public static final String DATE_SPLITTER = "/";
    public static final String COMMAND_SPLITTER = " ";
    public static final char CAP_ACKNOWLEDGEMENT = 'Y';
    public static final char ACKNOWLEDGEMENT = 'y';
    /** index suffix for done and delete duck.command */
    public static final int DELETE_INDEX = 7;
    public static final int DONE_INDEX = 5;
    public static final int USER_CHOICE_INDEX = 0;
    public static final int DESCRIPTION_MAXIMUM_SECTIONS = 2;
    public static final int DESCRIPTION_INDEX = 0;
    public static final int TIME_INDEX = 1;
    public static final int COMMAND_WORD_INDEX = 0;

    public static Command parseCommand(String userInput) {
        /** Split the first part, get the duck.command word */
        final String []commandTypeAndParams = userInput.split(COMMAND_SPLITTER);
        /** further split the user input, get the secondary part, the description */
        final String commandType = commandTypeAndParams[COMMAND_WORD_INDEX];
        final String commandArgs = userInput.substring(commandTypeAndParams[COMMAND_WORD_INDEX].length()).trim();
        //operates according to different duck.command word
        return getCommand(userInput, commandType, commandArgs);
    }

    /**
     * @param commandType, commandArgs the input String spited parts
     * @return parsed duck.command
     */
    private static Command getCommand(String commandWord, String commandType, String commandArgs) {
        switch (commandType){
        //Done
        case DoneCommand.COMMAND_WORD:
            return prepareDone(commandWord);
        //List
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        //Exit
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        //Add
        case AddCommand.COMMAND_WORD:
            return prepareAddTask(commandArgs);
        //Incorrect
        default:
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
    }

    private static Command prepareAddTask( String commandDescription) {
        return new AddCommand(new Task(commandDescription));
    }

    private static Command prepareDone (String args) {
        try {
            //targetIndex is the task needed to be done
            final int targetIndex = parseArgsAsDisplayedIndex(args);
            return new DoneCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        } catch (NumberFormatException | StringIndexOutOfBoundsException nfe) {
            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }

    public static int parseArgsAsDisplayedIndex(String args) throws ParseException, NumberFormatException,
            StringIndexOutOfBoundsException{
        final Matcher matcher = TASK_INDEX_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            throw new ParseException(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
        if (args.length() < Parser.DONE_INDEX) {
            throw new StringIndexOutOfBoundsException(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        return Integer.parseInt(args.substring(Parser.DONE_INDEX));
    }
}
