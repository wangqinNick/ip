package seedu.duck.util;

import java.io.File;

public class Message {

    public static final String DUCK_LOGIN = "Duck login";
    public static final String INCORRECT_USER_OR_PW = "Incorrect user or pw.";
    public static final String WELCOME_TEXT = "Welcome to Duck System";
    public static final char DONE = '✓';
    public static final char NOT_DONE = '✕';
    public static final String MESSAGE_EMPTY_LIST = "There is no task in the list!";
    public static final String MESSAGE_LIST_RESPOND_FORMAT = "%s";
    public static final String MESSAGE_TODO_LIST = "%d. [%c][%c] %s";
    public static final String MESSAGE_EVENT_LIST = "%d. %s";
    public static final String MESSAGE_TODO_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s";
    public static final String MESSAGE_DEADLINE_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_DEADLINE_LIST = "%d. %s";
    public static final String MESSAGE_EVENT_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid";
    public static final String JSON_FILE_PATH = "src"+ File.pathSeparator+"main"+File.pathSeparator+"data"+File.pathSeparator+"taskManager.json";
    public static final String MESSAGE_FILE_OPERATION_IO_ERROR = "Error writing to file: %s";
    public static final String MESSAGE_UNDO_SUCCESS = "Undo successfully!";
    public static final String MESSAGE_UNDO_UNSUCCESSFUL = "Sorry, there was an IO error when undoing the state.\n";
    public static final String MESSAGE_UNDO_AT_BEGINNING = "You are already at the initial state!\n";
    public static String messageAddTaskSuccess(String description) {
        return String.format("SUCCESS!! Task %s has been added.\n", description);
    }
}
