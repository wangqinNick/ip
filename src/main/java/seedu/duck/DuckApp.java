package seedu.duck;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.duck.data.StateManager;
import seedu.duck.gui.MainStage;
import seedu.duck.data.TaskManager;
import seedu.duck.storage.IOManager;
import static seedu.duck.util.Constant.*;
import static seedu.duck.util.Message.DUCK_LOGIN;
import static seedu.duck.util.Message.INCORRECT_USER_OR_PW;



/**
 * Runs the application.
 */
public class DuckApp extends Application {
    String user = DEFAULT_USERNAME;
    String pw = DEFAULT_PASSWORD;
    String checkUser, checkPw;

    public DuckApp() {

    }

    /**
     * init the program:
     * initialize the task manager, io manager, and the state manager
     */
    @Override
    public void init() {
        TaskManager.initialise();
        IOManager.initialise();
        IOManager.loadList();
        StateManager.initialise();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(DUCK_LOGIN);
        var bp = new BorderPane();
        bp.setPadding(new Insets(10, 50, 50, 50));
        var hb = new HBox();
        hb.setPadding(new Insets(20, 20, 20, 30));

        //Adding GridPane
        var gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(6);
        gridPane.setVgap(6);

        //Implementing Nodes for GridPane
        var lblUserName = new Label("Username");
        final var txtUserName = new TextField();
        var lblPassword = new Label("Password");
        final var pf = new PasswordField();
        var btnLogin = new Button("Login");
        final var lblMessage = new Label();

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);


        //Reflection for gridPane
        var r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect
        var dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        var text = new Text(DUCK_LOGIN);
        text.setFont(Font.font(DEFAULT_DIALOG_FONT, FontWeight.BOLD, DEFAULT_DIALOG_SIZE * 2));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().addAll(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");
        //Action for btnLogin
        btnLogin.setOnAction((EventHandler<javafx.event.ActionEvent>) event -> checkValidationAndLogin(txtUserName, pf, primaryStage, lblMessage));
        gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    checkValidationAndLogin(txtUserName, pf, primaryStage, lblMessage);
                }
            }
        });


        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        var scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(
                scene.widthProperty().asString().
                        concat(" : ").
                        concat(scene.heightProperty().asString()));
        //primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * check Login information: username and username
     * If valid, then login the system
     *
     * @param txtUserName input username
     * @param pf input password
     * @param primaryStage stage
     * @param lblMessage output information
     */
    private void checkValidationAndLogin(TextField txtUserName, PasswordField pf, Stage primaryStage, Label lblMessage) {
        checkUser = txtUserName.getText().toString();
        checkPw = pf.getText().toString();
        if (checkUser.equals(user) && checkPw.equals(pw)) {
            new MainStage();
            primaryStage.hide();
        } else {
            lblMessage.setText(INCORRECT_USER_OR_PW);
            lblMessage.setTextFill(Color.RED);
        }
        txtUserName.setText("");
        pf.setText("");
    }
}
