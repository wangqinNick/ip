package seedu.duck.util;

public class Message {

    public static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    public static final String DIVIDER = "-".repeat(101);
    public static final char DONE = 'D';
    public static final char NOTDONE = 'N';
    public static final String respondFormat = "===-             %-90s%n";
    public static final String MESSAGE_WELCOME = "Hello! I'm duck.system.Duck";
    public static final String MESSAGE_FAREWELL = "Bye. Hope to see you again soon!\n";
    public static final String MESSAGE_EMPTY_LIST = "There is no current duck.task in the list!";
    public static StringBuilder listMessage;
    public static final String MESSAGE_SHOW_TASK_NUMBER = "There are total %d duck.task(s) in the list";
    public static final String MESSAGE_LIST_RESPOND_FORMAT = "%-90s";
    public static final String MESSAGE_LS = "===-             ";
    public static final String LINE_PREFIX = "===-             ";
    public static final String MESSAGE_TODO_SUCCESS = "Got it. I've added this task: [ID:%d][%c][%c] %s";
    //public static final String MESSAGE_RS = "-===";
    public static final String MESSAGE_TASK_LIST = "%d. [%c] %s";
    public static final String MESSAGE_ALERT = "[ALERT!]";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid duck.command format!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The duck.task index provided is invalid";
    public static String messageAddTaskSuccess(String description) {
        return String.format("SUCCESS!! Task %s has been added.\n", description);
    }
    public static final String MESSAGE_DUPLICATE_TASK_ALERT_1 = "This task is same as task at [Index %d]";
    public static final String MESSAGE_DUPLICATE_TASK_ALERT_2 = "Do you want to add a duplicate task?";
    public static final String MESSAGE_DUPLICATE_TASK_ALERT_3 = "Press Y to add and others to not add: ";
    public static final String MESSAGE_DUPLICATE_TASK_NOT_ADDED = "The duplicate task is not added!";
}
