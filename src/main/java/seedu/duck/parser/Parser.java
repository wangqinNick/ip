package seedu.duck.parser;

import seedu.duck.command.Command;
import seedu.duck.command.DoneCommand;
import seedu.duck.command.ExitCommand;
import seedu.duck.command.IncorrectCommand;
import seedu.duck.command.ListCommand;
import seedu.duck.command.add.AddCommand;
import seedu.duck.command.add.AddDeadlineCommand;
import seedu.duck.command.add.AddEventCommand;
import seedu.duck.command.add.AddTodoCommand;
import seedu.duck.exception.ParseException;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.TodoTask;

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
    public static final int DONE_INDEX = 5;
    public static final int DESCRIPTION_INDEX = 0;
    public static final int TIME_INDEX = 1;
    public static final int COMMAND_WORD_INDEX = 0;

    public static Command parseCommand(String userInput) {
        if (userInput == null){
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        final String []commandTypeAndParams = userInput.split(COMMAND_SPLITTER);
        final String commandType = commandTypeAndParams[COMMAND_WORD_INDEX];
        final String commandArgs = userInput.substring(commandTypeAndParams[COMMAND_WORD_INDEX].length()).trim();
        return getCommand(userInput, commandType, commandArgs);
    }

    /**
     * @param commandType, commandArgs the input String spited parts
     * @return parsed duck.command
     */
    private static Command getCommand(String commandWord, String commandType, String commandArgs) {
        switch (commandType){
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
        taskDescriptionAndTime = commandArgs.split(DATE_SPLITTER);

        if (!isValid(taskDescriptionAndTime[DESCRIPTION_INDEX])){
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        if (!isValid(taskDescriptionAndTime[TIME_INDEX])){
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        return new AddDeadlineCommand(new DeadlineTask(taskDescriptionAndTime[DESCRIPTION_INDEX],taskDescriptionAndTime[TIME_INDEX]));
    }

    private static Command prepareAddEventTask(String commandDescription) {
        String [] taskDescriptionAndTime;
        if (!isValid(commandDescription)) {
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT);
        }
        taskDescriptionAndTime = commandDescription.split(DATE_SPLITTER);
        return new AddEventCommand(new EventTask(taskDescriptionAndTime[DESCRIPTION_INDEX],taskDescriptionAndTime[TIME_INDEX]));
    }

    private static Command prepareDone (String args) {
        try {
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

    private static Boolean isValid(String str) {
        return str.length() > 0;
    }
}
