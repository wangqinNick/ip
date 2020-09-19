package seedu.duck.parser;

import seedu.duck.command.Command;
import seedu.duck.command.DeleteCommand;
import seedu.duck.command.DoneCommand;
import seedu.duck.command.ExitCommand;
import seedu.duck.command.FindCommand;
import seedu.duck.command.HelpCommand;
import seedu.duck.command.IncorrectCommand;
import seedu.duck.command.ListCommand;
import seedu.duck.command.add.AddDeadlineCommand;
import seedu.duck.command.add.AddEventCommand;
import seedu.duck.command.add.AddTodoCommand;
import seedu.duck.exception.ParseException;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.TodoTask;
import seedu.duck.util.DateTime;
import seedu.duck.util.DateTimeFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duck.util.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.duck.util.Message.MESSAGE_INVALID_TASK_DISPLAYED_INDEX;

/**
 *  Parser the String to a Command object
 */
public class Parser {
    public static final Pattern TASK_INDEX_ARGS_FORMAT = Pattern.compile("(?<targetIndex>.+)");
    public static final String DEADLINE_DATE_SPLITTER = "/by";
    public static final String EVENT_DATE_SPLITTER = "/at";
    public static final String COMMAND_SPLITTER = " ";
    public static final int DONE_INDEX = 5;
    public static final int DELETE_INDEX = 7;
    public static final int DESCRIPTION_INDEX = 0;
    public static final int TIME_INDEX = 1;
    public static final int COMMAND_WORD_INDEX = 0;

    public static Command parseCommand(String userInput) {
        if (userInput == null){
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        final String []commandTypeAndParams = userInput.split(COMMAND_SPLITTER);
        var commandType = commandTypeAndParams[COMMAND_WORD_INDEX];
        final var commandArgs = userInput.substring(commandTypeAndParams[COMMAND_WORD_INDEX].length()).trim();
        return getCommand(userInput, commandType, commandArgs);
    }

    /**
     * @param commandType, commandArgs the input String spited parts
     * @return parsed duck.command
     */
    private static Command getCommand(String commandWord, String commandType, String commandArgs) {
        switch (commandType){
        //Help
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();
        //Find
        case FindCommand.COMMAND_WORD:
            return new FindCommand(commandArgs);
        //Delete
        case DeleteCommand.COMMAND_WORD:
            return prepareDelete(commandWord);
        //Add to-do
        case AddTodoCommand.COMMAND_WORD:
            return prepareAddTodoTask(commandArgs);
        //add event task
        case AddEventCommand.COMMAND_WORD:
            return prepareAddEventTask(commandArgs);
        //add deadline task
        case AddDeadlineCommand.COMMAND_WORD:
            return prepareAddDeadlineTask(commandArgs);
        //Done
        case DoneCommand.COMMAND_WORD:
            return prepareDone(commandWord);
        //List
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        //Exit
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        //Incorrect
        default:
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
    }



    private static Command prepareAddTodoTask(String commandArgs) {
        if (!isValid(commandArgs)) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        return new AddTodoCommand(new TodoTask(commandArgs));
    }

    private static Command prepareAddDeadlineTask(String commandArgs) {
        String [] taskDescriptionAndTime;
        if (!isValid(commandArgs)) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        taskDescriptionAndTime = commandArgs.split(DEADLINE_DATE_SPLITTER);
        if (!isValid(taskDescriptionAndTime[DESCRIPTION_INDEX])){
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        if (!isValid(taskDescriptionAndTime[TIME_INDEX])){
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        try {
            DateTime dateTime = DateTimeFormat.stringToDateTime(taskDescriptionAndTime[TIME_INDEX]);
            return new AddDeadlineCommand(new DeadlineTask(taskDescriptionAndTime[DESCRIPTION_INDEX],dateTime));
        } catch (DateTimeFormat.InvalidDateTimeException e) {
            return new AddDeadlineCommand(new DeadlineTask(taskDescriptionAndTime[DESCRIPTION_INDEX],taskDescriptionAndTime[TIME_INDEX]));
        }
    }

    private static Command prepareAddEventTask(String commandDescription) {
        String [] taskDescriptionAndTime;
        if (!isValid(commandDescription)) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        taskDescriptionAndTime = commandDescription.split(EVENT_DATE_SPLITTER);
        try {
            DateTime dateTime = DateTimeFormat.stringToDateTime(taskDescriptionAndTime[TIME_INDEX]);
            return new AddEventCommand(new EventTask(taskDescriptionAndTime[DESCRIPTION_INDEX], dateTime));
        } catch (DateTimeFormat.InvalidDateTimeException e) {
            return new AddEventCommand(new EventTask(taskDescriptionAndTime[DESCRIPTION_INDEX],taskDescriptionAndTime[TIME_INDEX]));
        }    }

    /**
     * Parses arguments in the context of the delete person command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareDelete(String args) {
        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args, DELETE_INDEX);
            return new DeleteCommand(targetIndex);
        } catch (ParseException | NumberFormatException pe) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        } catch (StringIndexOutOfBoundsException se) {
            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }

    private static Command prepareDone (String args) {
        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args, DONE_INDEX);
            return new DoneCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        } catch (NumberFormatException | StringIndexOutOfBoundsException nfe) {
            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }

    public static int parseArgsAsDisplayedIndex(String args, int indexOfIndex) throws ParseException,
                                                                                      NumberFormatException,
                                                                                      StringIndexOutOfBoundsException{
        final Matcher matcher = TASK_INDEX_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            throw new ParseException(MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
        if (args.length() < indexOfIndex) {
            throw new StringIndexOutOfBoundsException(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        return Integer.parseInt(args.substring(indexOfIndex)) - 2;
    }

    private static Boolean isValid(String str) {
        return str.length() > 0;
    }
}
