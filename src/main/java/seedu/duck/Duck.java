package seedu.duck;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.parser.Parser;
import seedu.duck.system.TaskManager;
import seedu.duck.ui.TextUi;
import seedu.duck.ui.Ui;

import java.util.NoSuchElementException;

import static seedu.duck.ui.TextUi.askForReInput;

public class Duck extends Application {

    static CommandResult commandResult;
    public static TaskManager taskManager;
    private String userCommand;

    public Duck() {
        taskManager = new TaskManager();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label
        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
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
