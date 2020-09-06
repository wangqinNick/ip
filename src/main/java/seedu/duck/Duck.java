package seedu.duck;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
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
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    static CommandResult commandResult;
    public static TaskManager taskManager;
    private String userCommand;

    public Duck() {
        taskManager = new TaskManager();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Step 1. Setting up required components

        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        //Step 2. Formatting the window to look as expected
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        // more code to be added here later


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
