package seedu.duck.gui;

import javafx.fxml.FXML;

import javax.swing.text.html.ImageView;

public class InfoWindow {

    @FXML
    private ImageView imageView;

    private MainStage parentController;
    public void setParentController(MainStage mainStage) {
        parentController = mainStage;
    }
}
