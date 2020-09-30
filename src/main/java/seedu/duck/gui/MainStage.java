package seedu.duck.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import seedu.duck.DuckApp;
import seedu.duck.Executor;
import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.HelpCommand;
import seedu.duck.command.PromptType;
import seedu.duck.data.CommandManager;
import seedu.duck.parser.Parser;

import java.io.IOException;

import static seedu.duck.util.Constant.DEFAULT_DIALOG_FONT;
import static seedu.duck.util.Constant.DEFAULT_DIALOG_SIZE;
import static seedu.duck.util.Message.WELCOME_TEXT;

public class MainStage {

    public static final int STAGE_HEIGHT = 700;
    public static final int STAGE_WIDTH = 600;
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/original.gif"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/tenor.gif"));
    private PromptType promptType = PromptType.INFORMATIVE;
    private static MediaView bgmView;
    /**
     * Set the property of the main stage
     */
    public MainStage(){
        Stage stage = new Stage();

        //
        MenuBar menuBar = new MenuBar();
        Menu menuNew= new Menu("New");
        Menu menuHelp= new Menu("Help");
        Menu menuAbout= new Menu("About");

        menuBar.getMenus().add(menuNew);
        menuBar.getMenus().add(menuHelp);
        menuBar.getMenus().add(menuAbout);

        MenuItem menuItem = new MenuItem("New Task");
        MenuItem menuItemHelp = new MenuItem("Display Help Message");
        MenuItem menuItemAbout = new MenuItem("Show developer Info");

        menuNew.getItems().add(menuItem);
        menuHelp.getItems().add(menuItemHelp);
        menuAbout.getItems().add(menuItemAbout);


        //Step 1. Setting up required components
        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);
        Font font = new Font(DEFAULT_DIALOG_FONT, DEFAULT_DIALOG_SIZE);
        userInput = new TextField();
        userInput.setFont(font);

        Button sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton,menuBar);
        Parent root = new StackPane( mainLayout);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        //Step 2. Formatting the window to look as expected
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(STAGE_HEIGHT);
        stage.setMinWidth(STAGE_WIDTH);

        mainLayout.setPrefSize(STAGE_WIDTH, STAGE_HEIGHT);

        scrollPane.setPrefSize(STAGE_WIDTH-15, STAGE_HEIGHT-65);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        Image backgroundImage = new Image(this.getClass().getResourceAsStream("/images/bgp.png"));
        dialogContainer.setBackground(new Background(new BackgroundImage(backgroundImage, null, null, null, null)));

        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                mainLayout.setLayoutY(-new_val.doubleValue());
            }
        });

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
        userInput.setPrefWidth(STAGE_WIDTH-75);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);
        AnchorPane.setRightAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(new Label(WELCOME_TEXT), new ImageView(duke), promptType));
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(new Label(HelpCommand.getFeedbackToUserInEnglish()), new ImageView(duke), promptType));
        //Part 3. Add functionality to handle user input.

        userInput.setOnKeyPressed(event -> handleKeyPress(event.getCode()));

        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        menuItem.setOnAction((event) -> {
            createNewTask();
        });

        menuItemAbout.setOnAction((event) -> {
            displayInfoMessage();
        });

        menuItemHelp.setOnAction((event) -> {
            displayHelpMessage();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });

    }

    /**
     * Iteration 2:
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke), promptType));
        userInput.clear();
    }

    /**
     * Return the response generated according to user input
     *
     * @param userInput userInput
     * @return the response
     */
    private String getResponse(String userInput) {
        Command parsedCommand = Parser.parseCommand(userInput);
        promptType = parsedCommand.getPromptType();
        CommandResult commandResult;
        commandResult = Executor.executeCommand(parsedCommand);
        CommandManager.add(userInput);
        return commandResult.getFeedbackToUser();
    }

    public static void setBgmView(MediaView mediaView) {
        bgmView = mediaView;
    }

    /**
     * Handles key presses for `userInput`, displaying the command history on
     * {@code KeyCode.UP} and {@code KeyCode.DOWN}.
     *
     * @param keyCode the key that was pressed by the user.
     */
    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode) {
        case UP:
            userInput.setText(CommandManager.traverseUpHistoryCommand());
            break;
        case DOWN:
            userInput.setText(CommandManager.traverseDownHistoryCommand());
            break;
        default:
            return;
        }
        // Set the caret position to the end of the string.
        userInput.positionCaret(userInput.getLength());
    }

    @FXML
    void createNewTask() {
        try {
            FXMLLoader loader = new FXMLLoader(DuckApp.class.getResource("/view/NewTaskWindow.fxml"));
            Parent root = loader.load();
            loader.<NewTaskWindowController>getController().setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Create New Task");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void displayInfoMessage() {
        try {
            FXMLLoader loader = new FXMLLoader(DuckApp.class.getResource("/view/InfoWindow.fxml"));
            Parent root = loader.load();
            loader.<InfoWindow>getController().setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Developer Info");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void displayHelpMessage() {
        try {
            FXMLLoader loader = new FXMLLoader(DuckApp.class.getResource("/view/HelpWindow.fxml"));
            Parent root = loader.load();
            loader.<HelpWindow>getController().setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Help Message");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
