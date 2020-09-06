package seedu.duck.ui;

import seedu.duck.Duck;
import seedu.duck.system.TaskManager;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;
import seedu.duck.task.TodoTask;
import seedu.duck.util.Message;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.ArrayList;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;
import static seedu.duck.util.Message.*;

public class TextUi {
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    public static final int INDEX_OFF_SET = -1;
    public static final int LIST_INDEX_OFFSET = 1;
    public static final Ansi.Color SYSTEM_COLOR_MESSAGE = BLUE;
    public static final Ansi.Color SYSTEM_COLOR_RESPONSE = GREEN;
    public static final Ansi.Color SYSTEM_COLOR_DIVIDER = BLACK;
    public static final Ansi.Color SYSTEM_COLOR_LOGO = MAGENTA;
    public static final Ansi.Color SYSTEM_COLOR_ALERT = RED;

    public static void showLogo() {
        AnsiConsole.systemInstall();
        ansi().reset();
        System.out.print(ansi().bold().fg(SYSTEM_COLOR_LOGO).a(Message.LOGO).reset());
        printDivider();
        AnsiConsole.systemUninstall();
    }

    public static void showGreetings() {
        AnsiConsole.systemInstall();
        printDivider();
        System.out.print(String.format(Message.respondFormat,
                ansi().bold().fg(SYSTEM_COLOR_MESSAGE).a(Message.MESSAGE_WELCOME).reset()) );
        printDivider();
        AnsiConsole.systemUninstall();
    }

    public static void showFarewells() {
        AnsiConsole.systemInstall();
        printDivider();
        System.out.println( ansi().fg(SYSTEM_COLOR_MESSAGE).a(Message.MESSAGE_FAREWELL).reset() );
        printDivider();
        AnsiConsole.systemUninstall();
    }

    //echo function, display user's input
    public static void showResult(String text) {
        //printDivider();
        printMessage(CYAN, text);
        printDivider();
    }

    /**
     * clear the screen.
     */
    public static void clearScreen() {
        AnsiConsole.systemInstall();
        System.out.println(ansi().eraseScreen());
        AnsiConsole.systemUninstall();
    }

    public static void printLS(){
        AnsiConsole.systemInstall();
        System.out.print(ansi().bold().fg(SYSTEM_COLOR_DIVIDER).a(MESSAGE_LS).reset());
        AnsiConsole.systemUninstall();
    }

    public static void printMessage(Ansi.Color color, String message){
        AnsiConsole.systemInstall();
        ansi().reset();
        System.out.print(String.format(Message.respondFormat,
                ansi().bold().fg(color).a(message).reset()));
        AnsiConsole.systemUninstall();
    }

    public static void printDivider() {
        AnsiConsole.systemInstall();
        System.out.println( ansi().bold().fg(SYSTEM_COLOR_DIVIDER).a(Message.DIVIDER).reset() );
        AnsiConsole.systemUninstall();
    }

    /**
     * Print all tasks in the duck.task list
     */
    public static String printAllTasks(ArrayList<Task> taskList){
        listMessage = new StringBuilder();
        getTaskListMessage();
        return listMessage.toString();
    }

    /**
     * get taskList message
     */
    private static void getTaskListMessage() {
        for (int index = LIST_INDEX_OFFSET; index <= TaskManager.size() ; index++) {
            Task task = TaskManager.get(index+ INDEX_OFF_SET);
            printTaskMessage(index, task);
        }
        printMessage(
                SYSTEM_COLOR_RESPONSE,
                String.format(MESSAGE_SHOW_TASK_NUMBER,
                TaskManager.size()));
    }

    private static void printTaskMessage(int index, Task task) {
        if (task instanceof TodoTask) {
            printTodoTask((TodoTask) task, index);
        } else if (task instanceof DeadlineTask) {
            printDeadlineTask((DeadlineTask) task, index);
        } else if( task instanceof EventTask) {
            printEventTask((EventTask) task, index);
        }
    }

    public static void printTodoTask(TodoTask todoTask, int index){
        printTask(SYSTEM_COLOR_RESPONSE,String.format(
                MESSAGE_LIST_RESPOND_FORMAT,
                String.format(
                    MESSAGE_TODO_LIST,
                    index,
                    todoTask.getType(),
                    todoTask.getChar(),
                    todoTask.getDescription())
                )
        ) ;
    }

    /**
     * print deadline-type task
     * @param deadlineTask deadline task to print
     * @param index index of deadline task
     */
    public static void printDeadlineTask(DeadlineTask deadlineTask, int index){
        printTask(SYSTEM_COLOR_RESPONSE,
                String.format(MESSAGE_LIST_RESPOND_FORMAT, String.format(
                    MESSAGE_DEADLINE_LIST,
                    index,
                    deadlineTask.getType(),
                    deadlineTask.getChar(),
                    deadlineTask.getDescription(),
                    deadlineTask.getTaskDeadline())));
    }

    /**
     * print event-type task
     * @param eventTask event task to print
     * @param index index of event task
     */
    public static void printEventTask(EventTask eventTask, int index){
        printTask(SYSTEM_COLOR_RESPONSE,String.format(MESSAGE_LIST_RESPOND_FORMAT, String.format(
                MESSAGE_EVENT_LIST,
                index,
                eventTask.getType(),
                eventTask.getChar(),
                eventTask.getDescription(),
                eventTask.getTime())));
    }

    public static void printTask(Ansi.Color color, String message){
        AnsiConsole.systemInstall();
        printLS();
        System.out.print(
                ansi().bold().fg(color).a(message).reset());
        //printRS();
        AnsiConsole.systemUninstall();
    }

    public static void printAlert(){
        AnsiConsole.systemInstall();
        ansi().reset();
        System.out.print(String.format(Message.respondFormat,
                ansi().bold().fg(SYSTEM_COLOR_ALERT).a(Message.MESSAGE_ALERT).reset()) );
        AnsiConsole.systemUninstall();
    }

    public static void alertToAddDuplicateTask(Task toCheck){
        printAlert();
        printMessage(SYSTEM_COLOR_MESSAGE,
                String.format(MESSAGE_DUPLICATE_TASK_ALERT_1, toCheck.getIndex()));
//        printMessage(SYSTEM_COLOR_MESSAGE,
//                MESSAGE_DUPLICATE_TASK_ALERT_2);
//        printMessage(SYSTEM_COLOR_MESSAGE,
//                MESSAGE_DUPLICATE_TASK_ALERT_3);
    }

    public static void printDuplicateTaskNotAdded(){
        printMessage(SYSTEM_COLOR_MESSAGE, MESSAGE_DUPLICATE_TASK_NOT_ADDED);
    }

    public static void askForReInput(){
        printMessage(SYSTEM_COLOR_MESSAGE, MESSAGE_ASK_FOR_REINPUT);
    }
}

