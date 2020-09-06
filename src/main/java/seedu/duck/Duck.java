package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.parser.Parser;
import seedu.duck.system.TaskManager;
import seedu.duck.ui.TextUi;
import seedu.duck.ui.Ui;

import java.util.NoSuchElementException;

import static seedu.duck.ui.TextUi.askForReInput;

public class Duck {

    static CommandResult commandResult;
    public static TaskManager taskManager;
    private String userCommand;

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
        while(true) {
            try{
                userCommand = Ui.getUserInput();
            } catch (NoSuchElementException ex1){
                askForReInput();
                do {
                    userCommand = Ui.getUserInput();
                } while (userCommand != null);
            } finally {
                Command parsedCommand = Parser.parseCommand(userCommand);
                Executor.executeCommand(parsedCommand);
            }
        }
    }
}
