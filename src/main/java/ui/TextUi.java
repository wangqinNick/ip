package ui;

import task.Task;
import util.Message;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.ArrayList;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;
import static util.Message.*;

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
     * Print all tasks in the task list
     */
    public static String printAllTasks(ArrayList<Task> taskList){
        //message for all tasks, combined together
        listMessage = new StringBuilder();
        getTaskListMessage(taskList);
        return listMessage.toString();
    }

    /**
     * get tasklist message
     * @param taskList
     */
    private static void getTaskListMessage(ArrayList<Task> taskList) {
        for (int index =  LIST_INDEX_OFFSET; index <= taskList.size() ; index++) {
            Task task = taskList.get(index+ INDEX_OFF_SET);
            printTaskMessage(index, task);
        }
        //print "there are 2 tasks in the list"
        TextUi.printMessage(TextUi.SYSTEM_COLOR_RESPONSE,
                String.format(MESSAGE_SHOW_TASK_NUMBER,
                        taskList.size()));
    }

    private static void printTaskMessage(int index, Task task) {
        printTask(task, index);
        System.out.println();
    }

    public static void printTask(Task task, int index){
        printTask(SYSTEM_COLOR_RESPONSE,String.format(Message.MESSAGE_LIST_RESPOND_FORMAT,
                String.format(
                        Message.MESSAGE_TASK_LIST,
                        index,
                        task.getChar(),
                        task.getDescription())));
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
}

