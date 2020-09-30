package seedu.duck.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.duck.data.StateManager;
import seedu.duck.data.TaskManager;
import seedu.duck.exception.DukeException;
import seedu.duck.storage.IOManager;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.TodoTask;

import java.io.IOException;

public class NewTaskWindowController {

    @FXML
    private TextArea descriptionTextField;
    @FXML
    private Button confirmButton;
    @FXML
    private ComboBox<String> typeSelector;
    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField hours;
    @FXML
    private TextField minutes;
    @FXML
    private Text dots;

    private MainStage parentController;

    private void hideTimeFields() {
        hours.setVisible(false);
        minutes.setVisible(false);
        dots.setVisible(false);
    }

    private void showTimeFields() {
        hours.setVisible(true);
        minutes.setVisible(true);
        dots.setVisible(true);
    }

    void setParentController(MainStage parentController) {
        this.parentController = parentController;
    }

    @FXML
    void confirm(ActionEvent event) {

        if (!typeSelector.getSelectionModel().isEmpty()) {
            String selected = typeSelector.getSelectionModel().getSelectedItem();
            try {
                switch (selected) {
                case "To-Do":
                    TaskManager.add(new TodoTask(descriptionTextField.getText()));
                    StateManager.saveState();
                    IOManager.saveAsJson();
                    break;
                case "Deadline": {
                    int hrs = Integer.parseInt(hours.getText());
                    int mins = Integer.parseInt(minutes.getText());
                    if (hrs >= 24 || hrs < 0 || mins < 0 || mins >= 60) {
                        throw new DukeException("Invalid time inputs.");
                    }
                    TaskManager.add(
                            new DeadlineTask(descriptionTextField.getText(),
                                    datePicker.getValue()));
                    StateManager.saveState();
                    IOManager.saveAsJson();
                    break;
                }
                case "Event": {
                    int hrs = Integer.parseInt(hours.getText());
                    int mins = Integer.parseInt(minutes.getText());
                    if (hrs >= 24 || hrs < 0 || mins < 0 || mins >= 60) {
                        throw new DukeException("Invalid time inputs.");
                    }
                    TaskManager.add(
                            new EventTask(descriptionTextField.getText(),
                                    datePicker.getValue()));
                    StateManager.saveState();
                    IOManager.saveAsJson();
                    break;
                }
                default:
                    break;
                }
            } catch (DukeException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.showAndWait();
            } catch (NullPointerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No date is picked.");
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please input valid numbers in time field.");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ((Stage) confirmButton.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {

        assert descriptionTextField != null :
                "fx:id=\"descriptionTextField\" was not injected: check your FXML file 'NewTaskWindow.fxml'.";
        assert confirmButton != null :
                "fx:id=\"confirmButton\" was not injected: check your FXML file 'NewTaskWindow.fxml'.";
        assert typeSelector != null :
                "fx:id=\"typeSelector\" was not injected: check your FXML file 'NewTaskWindow.fxml'.";
        assert dateLabel != null :
                "fx:id=\"dateLabel\" was not injected: check your FXML file 'NewTaskWindow.fxml'.";
        assert datePicker != null :
                "fx:id=\"datePicker\" was not injected: check your FXML file 'NewTaskWindow.fxml'.";

        dateLabel.setVisible(false);
        datePicker.setVisible(false);
        hideTimeFields();
        ObservableList<String> items = FXCollections.observableArrayList("To-Do", "Deadline", "Event");
        typeSelector.setItems(items);
        typeSelector.setOnAction(event -> {
            String selected = typeSelector.getSelectionModel().getSelectedItem();
            switch (selected) {
            case "To-Do":
                dateLabel.setVisible(false);
                datePicker.setVisible(false);
                hideTimeFields();
                break;
            case "Deadline":
                dateLabel.setText("by");
                dateLabel.setVisible(true);
                datePicker.setVisible(true);
                showTimeFields();
                break;
            case "Event":
                dateLabel.setText("at");
                dateLabel.setVisible(true);
                datePicker.setVisible(true);
                showTimeFields();
                break;
            default:
                break;
            }
        });
    }
}
