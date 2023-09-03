package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;

public class MainViewController {

    @FXML
    private ListView<String> lvTaskCompleted;

    @FXML
    private ListView<String> lvTaskList;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtTask;

    // source -> Drag detected
    // target -> Drag over + Drag drop

    @FXML
    void lvTaskCompletedOnDragDropped(DragEvent e) {
        String completedTask = e.getDragboard().getString();
        lvTaskCompleted.getItems().add(completedTask);
        lvTaskList.getItems().remove(completedTask);
    }

    @FXML
    void lvTaskCompletedOnDragOver(DragEvent e) {
        // accept to drop anything dragged over here
        e.acceptTransferModes(TransferMode.ANY);
    }

    @FXML
    void lvTaskListOnDragDetected(MouseEvent e) {
        /* Hey! I want to drag and drop something
           Great! What do you want to drag? */
        Dragboard dragboard = lvTaskList.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent cp = new ClipboardContent();
        cp.putString(lvTaskList.getSelectionModel().getSelectedItem());
        dragboard.setContent(cp);
    }

    @FXML
    void txtTaskOnAction(ActionEvent e) {
    String task = txtTask.getText().strip();
    if(task.isBlank()){
        txtTask.requestFocus();
        txtTask.selectAll();
        return;
    }
        ObservableList<String> taskList = lvTaskList.getItems();
    if(taskList.contains(task)){
        new Alert(Alert.AlertType.ERROR,"Task already exists").show();
        txtTask.requestFocus();
        txtTask.selectAll();
        return;
    }
    taskList.add(task);
    txtTask.clear();
    }

}
