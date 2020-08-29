package seedu.duck;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.parser.Parser;
import seedu.duck.system.TaskManager;
import seedu.duck.ui.TextUi;
import seedu.duck.ui.Ui;

public class Duck {

    static CommandResult commandResult;
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
        while(true) {
            String userCommand = Ui.getUserInput();
            Command parsedCommand = Parser.parseCommand(userCommand);
            Executor.executeCommand(parsedCommand);
        }
    }
}
