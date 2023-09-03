package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainViewController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnComboBox;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnRemove;

    @FXML
    private ListView<String> lvSelectedSubject;

    @FXML
    private ListView<String> lvSubject;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtSubject;

    public  void initialize(){
        btnNext.setTooltip(new Tooltip("Click to select Subject"));
        btnBack.setTooltip(new Tooltip("Click to remove subject"));
        Font fontRef = Font.font(12);
        btnNext.getTooltip().setFont(fontRef);
        btnBack.getTooltip().setFont(fontRef);

        Button[] buttons = new Button[]{btnClear,btnRemove,btnNext,btnBack};
            for (int i = 0; i < buttons.length; i++) {
            buttons[i].setDisable(true);
        }

        ObservableList<String> subjectList = lvSubject.getItems();
        subjectList.addListener((Observable O) -> {
            btnClear.setDisable(subjectList.isEmpty());
        });

        lvSubject.getSelectionModel().selectedItemProperty().addListener( e -> {
            btnRemove.setDisable(lvSubject.getSelectionModel().getSelectedItem() == null);
            btnNext.setDisable(btnRemove.isDisable());
        });

        lvSelectedSubject.getSelectionModel().selectedItemProperty().addListener( e -> {
            btnBack.setDisable(lvSelectedSubject.getSelectionModel().getSelectedItem() == null);
        });
    }
    @FXML
    void btnBackOnAction(ActionEvent e) {
        ObservableList<String> subjectList = lvSubject.getItems();
        ObservableList<String> selectedSubjectList = lvSelectedSubject.getItems();

        String selectedSubject = lvSelectedSubject.getSelectionModel().getSelectedItem();
        selectedSubjectList.remove(selectedSubject);
        subjectList.add(selectedSubject);
    }

    @FXML
    void btnClearOnAction(ActionEvent e) {
    ObservableList<String> subjectList = lvSubject.getItems();
    subjectList.clear();
    }

    @FXML
    void btnComboBox(ActionEvent e) throws  Exception{
        AnchorPane rootCombobox = FXMLLoader.load(getClass().getResource("/view/ComboboxScene.fxml"));
        Scene comboBoxScene = new Scene(rootCombobox);
        Stage stage = new Stage();
        stage.setScene(comboBoxScene);
        stage.setTitle("Combo Box");
        stage.show();
    }

    @FXML
    void btnNextOnAction(ActionEvent e) {
    ObservableList<String> subjectList = lvSubject.getItems();
    ObservableList<String> selectedSubjectList = lvSelectedSubject.getItems();

    String selectedSubject = lvSubject.getSelectionModel().getSelectedItem();
    subjectList.remove(selectedSubject);
    selectedSubjectList.add(selectedSubject);
    }

    @FXML
    void btnRemoveOnAction(ActionEvent e) {
        lvSubject.getItems().remove(lvSubject.getSelectionModel().getSelectedItem());
        lvSubject.getSelectionModel().clearSelection();

    }

    @FXML
    void lvSelectedSubjectOnKeyPressed(KeyEvent e) {
    if(e.getCode() == KeyCode.BACK_SPACE) btnBack.fire();
    }

    @FXML
    void lvSubjectOnKeyPressed(KeyEvent e) {
    if(e.getCode()== KeyCode.ENTER) btnNext.fire();
    else if (e.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    @FXML
    void txtSubjectOnAction(ActionEvent e) {
    String subject = txtSubject.getText().strip();
    if (subject.isBlank()) {
        new Alert(Alert.AlertType.ERROR,"Subject name can't be empty").show();
        txtSubject.selectAll();
        //txtSubject.requestFocus();
        return;
    }

    ObservableList<String> subjectList = lvSubject.getItems();

    if(subjectList.contains(subject)){
        new Alert(Alert.AlertType.ERROR,subject + " already exist. Try new subject").show();
        txtSubject.selectAll();
        return;
    } else {
        subjectList.add(subject);
        txtSubject.clear();
    }


    }

}
