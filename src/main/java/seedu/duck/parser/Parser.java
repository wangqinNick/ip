package seedu.duck.parser;

import seedu.duck.command.ChangeLanguageCommand;
import seedu.duck.command.ClearCommand;
import seedu.duck.command.Command;
import seedu.duck.command.DeleteCommand;
import seedu.duck.command.DoneCommand;
import seedu.duck.command.DueCommand;
import seedu.duck.command.ExitCommand;
import seedu.duck.command.FindCommand;
import seedu.duck.command.HelpCommand;
import seedu.duck.command.IncorrectCommand;
import seedu.duck.command.ListCommand;
import seedu.duck.command.add.AddDeadlineCommand;
import seedu.duck.command.add.AddEventCommand;
import seedu.duck.command.add.AddTodoCommand;
import seedu.duck.command.misc.UndoCommand;
import seedu.duck.data.TaskManager;
import seedu.duck.exception.ParseException;
import seedu.duck.setting.SystemSetting;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.TodoTask;
import seedu.duck.util.DateTimeFormat;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.duck.util.Message.*;


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
            return getIncorrectCommand();
        }
        final String []commandTypeAndParams = userInput.split(COMMAND_SPLITTER);
        var commandType = commandTypeAndParams[COMMAND_WORD_INDEX];
        final var commandArgs = userInput.substring(commandTypeAndParams[COMMAND_WORD_INDEX].length()).trim();
        return getCommand(userInput, commandType, commandArgs);
    }

    /**
     * Return the command parsed from the user input
     *
     * @param commandType, commandArgs the input String spited parts
     * @return parsed duck.command
     */
    private static Command getCommand(String commandWord, String commandType, String commandArgs) {
        switch (commandType){
        //Change Language
        case ChangeLanguageCommand.COMMAND_WORD:
            return prepareChangeLanguageCommand(commandArgs);
        //Clear
        case ClearCommand.COMMAND_WORD:
            return prepareClearCommand();
        //Due
        case DueCommand.COMMAND_WORD:
            return prepareDueCommand(commandArgs);
        //Undo
        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();
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
            return getIncorrectCommand();
        }
    }

    private static Command prepareChangeLanguageCommand(String commandArgs){
        return new ChangeLanguageCommand(commandArgs.trim());
    }

    private static Command prepareClearCommand(){
        if (TaskManager.isEmpty()){
            switch (SystemSetting.getSystemLanguage()) {
            case CHINESE:
                return new IncorrectCommand(MESSAGE_EMPTY_LIST_IN_CHINESE);
            case ENGLISH:
            default:
                return new IncorrectCommand(MESSAGE_EMPTY_LIST_IN_ENGLISH);
            }
        } else {
            return new ClearCommand();
        }
    }

    /**
     * Return the command parsed from user input argument
     *
     * @param commandArgs user input argument
     * @return the parsed command
     */
    private static Command prepareDueCommand(String commandArgs){
        try {
            return new DueCommand(DateTimeFormat.stringToDate(commandArgs));
        } catch (DateTimeFormat.InvalidDateTimeException e) {
            return new IncorrectCommand("Invalid Date!");
        }
    }

    /**
     * Return the command parsed from user input argument
     *
     * @param commandArgs user input argument
     * @return the parsed command
     */
    private static Command prepareAddTodoTask(String commandArgs) {
        if (isEmpty(commandArgs)) {
            return getIncorrectCommand();
        }
        return new AddTodoCommand(new TodoTask(commandArgs));
    }

    /**
     * Return the command parsed from user input argument
     *
     * @param commandArgs user input argument
     * @return the parsed command
     */
    private static Command prepareAddDeadlineTask(String commandArgs) {
        String [] taskDescriptionAndTime;
        if (isEmpty(commandArgs)) {
            return getIncorrectCommand();
        }
        taskDescriptionAndTime = commandArgs.split(DEADLINE_DATE_SPLITTER);
        if (isEmpty(taskDescriptionAndTime[DESCRIPTION_INDEX])){
            return getIncorrectCommand();
        }
        if (isEmpty(taskDescriptionAndTime[TIME_INDEX])){
            return getIncorrectCommand();
        }
        try {
            LocalDate localDate = DateTimeFormat.stringToDate(taskDescriptionAndTime[TIME_INDEX].trim());
            return new AddDeadlineCommand(new DeadlineTask(taskDescriptionAndTime[DESCRIPTION_INDEX],localDate));
        } catch (DateTimeFormat.InvalidDateTimeException e) {
            return new AddDeadlineCommand(new DeadlineTask(taskDescriptionAndTime[DESCRIPTION_INDEX],taskDescriptionAndTime[TIME_INDEX]));
        }
    }

    private static Command getIncorrectCommand() {
        switch (SystemSetting.getSystemLanguage()) {
        case CHINESE:
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT_IN_CHINESE);
        case ENGLISH:
        default:
            return new IncorrectCommand(MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH);
        }
    }

    /**
     * Return the command parsed from user input argument
     *
     * @param commandDescription user input argument
     * @return the parsed command
     */
    private static Command prepareAddEventTask(String commandDescription) {
        String [] taskDescriptionAndTime;
        if (isEmpty(commandDescription)) {
            return getIncorrectCommand();
        }
        taskDescriptionAndTime = commandDescription.split(EVENT_DATE_SPLITTER);
        try {
            LocalDate localDate = DateTimeFormat.stringToDate(taskDescriptionAndTime[TIME_INDEX].trim());
            return new AddEventCommand(new EventTask(taskDescriptionAndTime[DESCRIPTION_INDEX], localDate));
        } catch (DateTimeFormat.InvalidDateTimeException e) {
            return new AddEventCommand(new EventTask(taskDescriptionAndTime[DESCRIPTION_INDEX],taskDescriptionAndTime[TIME_INDEX]));
        }    }

    /**
     * Return the arguments in the context of the delete person command
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareDelete(String args) {
        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args, DELETE_INDEX);
            return new DeleteCommand(targetIndex);
        } catch (ParseException | NumberFormatException pe) {
            return getIncorrectCommand();
        } catch (StringIndexOutOfBoundsException se) {
            return getIncorrectCommandAccordingToSystemLanguage();
        }
    }

    /**
     * Return the command parsed from user input argument
     *
     * @param args user input argument
     * @return the parsed command
     */
    private static Command prepareDone (String args) {
        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args, DONE_INDEX);
            return new DoneCommand(targetIndex);
        } catch (ParseException pe) {
            return getIncorrectCommand();
        } catch (NumberFormatException | StringIndexOutOfBoundsException nfe) {
            return getIncorrectCommandAccordingToSystemLanguage();
        }
    }

    private static Command getIncorrectCommandAccordingToSystemLanguage() {
        switch (SystemSetting.getSystemLanguage()) {
        case CHINESE:
            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_CHINESE);
        case ENGLISH:
        default:
            return new IncorrectCommand(MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_ENGLISH);
        }
    }

    /**
     * Return the integer index parsed from user input
     *
     * @param args user input
     * @param indexOfIndex the index of "Index" part in user input String array
     * @return  the integer index
     * @throws ParseException parseException if the index cannot be parsed
     * @throws NumberFormatException numberFormatException if the index is not is not a number
     * @throws StringIndexOutOfBoundsException stringIndexOutOfBoundsException if the index is missing
     */
    public static int parseArgsAsDisplayedIndex(String args, int indexOfIndex) throws ParseException,
                                                                                      NumberFormatException,
                                                                                      StringIndexOutOfBoundsException{
        final Matcher matcher = TASK_INDEX_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            switch (SystemSetting.getSystemLanguage()) {
            case CHINESE:
                throw new ParseException(MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_CHINESE);
            case ENGLISH:
            default:
                throw new ParseException(MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_ENGLISH);
            }
        }
        if (args.length() < indexOfIndex) {
            switch (SystemSetting.getSystemLanguage()) {
            case CHINESE:
                throw new StringIndexOutOfBoundsException(MESSAGE_INVALID_COMMAND_FORMAT_IN_CHINESE);
            case ENGLISH:
            default:
                throw new StringIndexOutOfBoundsException(MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH);
            }
        }
        return Integer.parseInt(args.substring(indexOfIndex)) - 2;
    }

    /**
     * Return true if the user input is empty
     *
     * @param str user input String
     * @return true if the user input is empty
     */
    private static Boolean isEmpty(String str) {
        return str.length() == 0;
    }
}
