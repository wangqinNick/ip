package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.ExitCommand;
import seedu.duck.parser.Parser;
import seedu.duck.system.TaskManager;
import seedu.duck.ui.TextUi;

import java.util.Scanner;


public class Duck {
    private CommandResult commandResult;
    public static TaskManager taskManager;

    public Duck() {
        taskManager = new TaskManager();
    }

    public static void main(String[] args) {
        new Duck().run();
    }

    private void run() {
        welcomeUser();
        runCommandLoopUntilExitCommand();
        //farewellUser();
    }

    public void welcomeUser() {
        TextUi.clearScreen();
        TextUi.showGreetings();
    }

    public void farewellUser() {
        TextUi.clearScreen();
        TextUi.showFarewells();
        TextUi.clearScreen();
    }

    private void runCommandLoopUntilExitCommand() {
        Command command;
        String userCommandText;
        Scanner scanner = new Scanner(System.in);
        do {
            userCommandText = scanner.nextLine();
            command = Parser.parseCommand(userCommandText);
            executeCommand(command);
        } while (!ExitCommand.isExit(command));
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
