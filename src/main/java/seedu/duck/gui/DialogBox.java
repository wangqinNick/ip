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
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import static javafx.scene.layout.BorderStroke.MEDIUM;
import static seedu.duck.util.Constant.*;

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
        customLabelAndImageView(l, iv, Color.web(DEFAULT_DIALOG_COLOR));
        return new DialogBox(l, iv);
    }

    public static DialogBox getDukeDialog(Label l, ImageView iv, boolean isValidCommand) {
        if (isValidCommand) {
            customLabelAndImageView(l, iv, Color.web(DEFAULT_DIALOG_COLOR));
        } else {
            customLabelAndImageView(l, iv, Color.web(WARNING_DIALOG_COLOR));
        }
        var db = new DialogBox(l, iv);
        db.flip();
        return db;
    }

    private static void customLabelAndImageView(Label l, ImageView iv, Paint paint) {
        Font font = new Font(DEFAULT_DIALOG_FONT, DEFAULT_DIALOG_SIZE);
        l.setFont(font);
        l.setMaxWidth(375);
        l.setMinHeight(50);
        l.setBorder(new Border(new BorderStroke(Color.web(DEFAULT_DIALOG_BORDER_COLOR), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, MEDIUM)));
        l.setBackground(new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY)));
        iv.setPreserveRatio(true);
    }
}