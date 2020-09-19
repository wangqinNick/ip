package seedu.duck.gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import seedu.duck.Executor;
import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;
import seedu.duck.command.HelpCommand;
import seedu.duck.command.PromptType;
import seedu.duck.parser.Parser;

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

    /**
     * Set the property of the main stage
     */
    public MainStage(){
        Stage stage = new Stage();
        var bgpView = getBackgroundImage();
        var bgmView = getBackgroundMusic();
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
        AnchorPane subLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);
        subLayout.getChildren().addAll(bgmView, bgpView);

        Parent root = new StackPane(mainLayout, subLayout);
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

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
        userInput.setPrefWidth(STAGE_WIDTH-75);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(new Label(WELCOME_TEXT), new ImageView(duke), promptType));
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(new Label(HelpCommand.getFeedbackToUser()), new ImageView(duke), promptType));
        //Part 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });

    }
    private ImageView getBackgroundImage() {
        Image backgroundImage = new Image(this.getClass().getResourceAsStream("/images/bgp.png"));
        ImageView bgpView = new ImageView(backgroundImage);
        bgpView.setOpacity(0.2);
        return bgpView;
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
        CommandResult commandResult = Executor.executeCommand(parsedCommand);
        return commandResult.getFeedbackToUser();
    }

    /**
     * Returns the background music generated
     *
     * @return background music generated
     */
    private MediaView getBackgroundMusic() {
        Media backgroundMusic = new Media(getClass().getResource("/music/windbgm1.mp3").toExternalForm());
        MediaPlayer backgroundMusicPlayer = new MediaPlayer(backgroundMusic);
        setBackgroundMusic(backgroundMusicPlayer);
        //***************** loop (repeat) the music  ******************
        backgroundMusicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                backgroundMusicPlayer.seek(Duration.ZERO);
            }
        });
        return new MediaView(backgroundMusicPlayer);
    }

    /**
     * Sets the property of the background music
     * @param backgroundMusicPlayer the background music
     */
    private void setBackgroundMusic(MediaPlayer backgroundMusicPlayer) {
        backgroundMusicPlayer.setAutoPlay(true);
        backgroundMusicPlayer.setVolume(0.9);
    }
}
