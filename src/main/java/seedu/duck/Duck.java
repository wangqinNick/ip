package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.parser.Parser;
import seedu.duck.system.TaskManager;
import seedu.duck.ui.TextUi;

import java.util.Scanner;

public class Duck {

    private static final Scanner SCANNER = new Scanner(System.in);
    private CommandResult commandResult;
    public static TaskManager taskManager;

    public Duck() {
        taskManager = new TaskManager();
    }

    public static void main(String[] args) {
        new Duck().run();
    }

    private void run() {
        initDuck();
        showWelcomeMessage();
        runCommandLoopUntilExitCommand();
    }

    private static void initDuck(){
        //initialize manger, data
    }

    public static void showWelcomeMessage() {
        TextUi.clearScreen();
        TextUi.showGreetings();
    }

    private void runCommandLoopUntilExitCommand() {
        Command command;
        String inputLine;
        while(true) {
            inputLine = getUserInput();
            command = Parser.parseCommand(inputLine);
            executeCommand(command);
        }
    }

    private static String getUserInput() {
        String inputLine = SCANNER.nextLine();
        return inputLine;
    }

    private void executeCommand(Command command) {
        try {
            command.setData(taskManager);
            commandResult = command.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
