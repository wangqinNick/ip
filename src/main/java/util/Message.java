package util;

public class Message {

    public static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    public static final String DIVIDER = "-".repeat(100);
    public static final String respondFormat = "===-             %-70s-===%n";
    public static final String MESSAGE_WELCOME = "Hello! I'm Duck";
    public static final String MESSAGE_FAREWELL = "Bye. Hope to see you again soon!\n";
    public static final String MESSAGE_EMPTY_LIST = "There is no current task in the list!";
    public static StringBuilder listMessage;
    public static final String MESSAGE_SHOW_TASK_NUMBER = "There are total %d task(s) in the list";
    public static final String MESSAGE_LIST_RESPOND_FORMAT = "%-60s";
    public static final String MESSAGE_LS = "===-             ";
    public static final String MESSAGE_RS = "-===";
    public static final String MESSAGE_TASK_LIST = "%d. %s";
    public static String messageAddTaskSuccess(String description) {
        return String.format("SUCCESS!! Task %s has been added.\n", description);
    }

}
