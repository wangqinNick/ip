package seedu.duck.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LoginStage {

    LoginStage()
    {
        Stage subStage = new Stage();
        subStage.setTitle("New Stage");
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);
        root.getChildren().add(new Button("New Stage"));
        subStage.setScene(scene);
        subStage.show();
    }
}
