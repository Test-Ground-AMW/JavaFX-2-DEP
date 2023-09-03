package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.tm.Student;

public class MainViewController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtNumber;
    public ComboBox<String> cmbProgramme;
    public Button btnSave;
    public Button btnDelete;
    public TableView<Student> tblStudents;
    public Button btnNewStudent;
    public AnchorPane root;

    public void initialize(){
        txtName.requestFocus();
        btnDelete.setDisable(true);
        ObservableList<String> programmes = cmbProgramme.getItems();
        programmes.addAll("Direct Entry Programme",
                "Graduate Diploma in Software Engineering",
                "Comprehensive master java Diploma",
                "Advanced Business solution Development",
                "Advanced Mobile Application Development");

        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Programme"));
        tblStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ContactNo"));


        tblStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current)->{
            btnDelete.setDisable(current==null);
            if(current!=null){
                txtID.setText(String.format("S-%04s",current.getId()));
                txtName.setText(current.getName());
                cmbProgramme.setValue(current.getProgramme());
                txtNumber.setText(current.getContactNo());
            }
        });
    }

    public void cmbProgrammeOnAction(ActionEvent e) {

    }

    public void btnSaveOnAction(ActionEvent e) {
        if(txtName.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Name can't be empty!").show();
            txtName.requestFocus();
            return;
        } else if (cmbProgramme.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please select the programme").show();
            cmbProgramme.requestFocus();
            return;
        } else if (txtNumber.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR,"Contact number can't be empty!").show();
            txtNumber.requestFocus();
            return;
        }
        int id = Integer.parseInt(txtID.getText().substring(2));
        String name = txtName.getText().strip();
        String programme = cmbProgramme.getSelectionModel().getSelectedItem();
        String contactNo = txtNumber.getText().strip();

        Student student = new Student(id, name, programme, contactNo);
        ObservableList<Student> studentList = tblStudents.getItems();
        studentList.add(student);
        btnNewStudent.fire();


    }

    public void btnDeleteOnAction(ActionEvent e) {
        ObservableList<Student> studentList = tblStudents.getItems();
        Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        studentList.remove(selectedStudent);
        if(studentList.isEmpty()) btnNewStudent.fire();


    }

    public void btnNewStudentOnAction(ActionEvent e) {
        txtID.setText(generateNewId());
        txtName.clear();
        txtNumber.clear();
        cmbProgramme.getSelectionModel().clearSelection();
        txtName.requestFocus();
    }

    String generateNewId(){
        ObservableList<Student> studentList = tblStudents.getItems();
        if (!studentList.isEmpty()){
            int newId = studentList.get(studentList.size() - 1).getId() + 1;
            return String.format("S-%04d", newId);
        }else{
            return "S-0001";
        }
    }
}
