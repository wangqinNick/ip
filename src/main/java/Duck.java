import command.Command;
import command.CommandResult;
import system.TaskManager;
import ui.TextUi;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Duck {
    private CommandResult commandResult;
    private TaskManager taskManager;

    /**
     * constructor of duck.
     */
    public Duck() {
        taskManager = new TaskManager();
    }

    public static void main(String[] args) {
        new Duck().run();
        TextUi.showFarewells();
    }

    private void run() {
        TextUi.showGreetings();
        runCommandLoopUntilExitCommand();
    }

    /**
     * Method to print the welcome message to the user.
     */
    public void welcomeUser() {
        TextUi.clearScreen();
        //TextUi.showLogo();
        TextUi.showGreetings();
    }

    private void runCommandLoopUntilExitCommand() {
        Command command;
        String userCommandText;
        Scanner scanner = new Scanner(System.in);
        do {
            userCommandText = scanner.nextLine();
            echo(userCommandText);
        } while (!userCommandText.equals("bye"));
    }

    public static void echo(String userCommandText) {
        System.out.println(userCommandText);
        TextUi.printDivider();
    }
}
