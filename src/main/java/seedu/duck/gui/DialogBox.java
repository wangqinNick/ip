package seedu.duck.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static javafx.scene.layout.BorderStroke.MEDIUM;

public class DialogBox extends HBox {

    public DialogBox(Label l, ImageView iv) {

        l.setWrapText(true);
        iv.setFitWidth(100.0);
        iv.setFitHeight(100.0);

        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(l, iv);
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
        customLabelAndImageView(l, iv);
        return new DialogBox(l, iv);
    }

    public static DialogBox getDukeDialog(Label l, ImageView iv) {
        customLabelAndImageView(l, iv);
        var db = new DialogBox(l, iv);
        db.flip();
        return db;
    }

    private static void customLabelAndImageView(Label l, ImageView iv) {
        Font font = new Font("Courier", 14);
        l.setFont(font);
        l.setMaxWidth(375);
        l.setMinHeight(50);
        l.setBorder(new Border(new BorderStroke(Color.web("#4141B2"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, MEDIUM)));
        l.setBackground(new Background(new BackgroundFill(Color.web("#9ED49E"), CornerRadii.EMPTY, Insets.EMPTY)));
        iv.setPreserveRatio(true);
    }
}