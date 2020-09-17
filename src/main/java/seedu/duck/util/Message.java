package seedu.duck.util;

import java.io.File;

public class Message {

    public static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    public static final String WELCOME_TEXT = "Welcome to Duck Syetem";
    public static final char DONE = 'D';
    public static final char NOT_DONE = 'N';
    public static final String MESSAGE_EMPTY_LIST = "There is no current duck.task in the list!";
    public static final String MESSAGE_LIST_RESPOND_FORMAT = "%s";
    public static final String MESSAGE_TODO_LIST = "%d. [%c][%c] %s";
    public static final String MESSAGE_EVENT_LIST = "%d. %s";
    public static final String MESSAGE_TODO_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s";
    public static final String MESSAGE_ALERT = "[ALERT!]";
    public static final String MESSAGE_DEADLINE_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_DEADLINE_LIST = "%d. %s";
    public static final String MESSAGE_EVENT_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid duck.command format!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The duck.task index provided is invalid";
    public static final String JSON_FILE_PATH = "src"+ File.pathSeparator+"main"+File.pathSeparator+"data"+File.pathSeparator+"taskManager.json";
    public static final String MESSAGE_FILE_OPERATION_IO_ERROR = "Error writing to file: %s";
    public static final String MESSAGE__NOT_STANDARD_TIME_FORMAT = "Warning: The input date can not be understood!";
    public static String messageAddTaskSuccess(String description) {
        return String.format("SUCCESS!! Task %s has been added.\n", description);
    }
}
