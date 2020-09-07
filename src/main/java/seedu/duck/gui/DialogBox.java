package seedu.duck.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import static javafx.scene.layout.BorderStroke.MEDIUM;

public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    public DialogBox(Label l, ImageView iv) {
        text = l;
        displayPicture = iv;

        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);

        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, displayPicture);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public static DialogBox getUserDialog(Label l, ImageView iv) {
        l.setPrefWidth(100);
        l.setPrefHeight(30);
        l.setBorder(new Border(new BorderStroke(Color.web("#4141B2"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, MEDIUM)));
        l.setBackground(new Background(new BackgroundFill(Color.web("#9ED49E"), CornerRadii.EMPTY, Insets.EMPTY)));
        return new DialogBox(l, iv);
    }

    public static DialogBox getDukeDialog(Label l, ImageView iv) {
        l.setPrefWidth(100);
        l.setPrefHeight(30);
        l.setBorder(new Border(new BorderStroke(Color.web("#4141B2"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, MEDIUM)));
        l.setBackground(new Background(new BackgroundFill(Color.web("#9ED49E"), CornerRadii.EMPTY, Insets.EMPTY)));
        var db = new DialogBox(l, iv);
        db.flip();
        return db;
    }
}