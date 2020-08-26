package util;

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
    public static final String MESSAGE_WELCOME = "Hello! I'm Duck";
    public static final String MESSAGE_FAREWELL = "Bye. Hope to see you again soon!\n";
    public static final String MESSAGE_EMPTY_LIST = "There is no current task in the list!";
    public static StringBuilder listMessage;
    public static final String MESSAGE_SHOW_TASK_NUMBER = "There are total %d task(s) in the list";
    public static final String MESSAGE_LIST_RESPOND_FORMAT = "%-90s";
    public static final String MESSAGE_LS = "===-             ";
    //public static final String MESSAGE_RS = "-===";
    public static final String MESSAGE_TASK_LIST = "%d. [%c] %s";
    public static final String MESSAGE_ALERT = "[ALERT!]";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid";
    public static String messageAddTaskSuccess(String description) {
        return String.format("SUCCESS!! Task %s has been added.\n", description);
    }

}
