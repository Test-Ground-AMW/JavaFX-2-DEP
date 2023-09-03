package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ComboboxController {

    @FXML
    private Button btnClearCountry;

    @FXML
    private Button btnRemoveCountry;

    @FXML
    private ComboBox<String> cbCountry;

    @FXML
    private Label lblCountry;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCountry;

    public void initialize(){
       btnRemoveCountry.setDisable(true);
       btnClearCountry.setDisable(true);
       cbCountry.setDisable(true);

        cbCountry.getItems().addListener((Observable o) -> {
        cbCountry.setDisable(cbCountry.getItems().isEmpty());
        btnClearCountry.setDisable(cbCountry.isDisable());
       });

       cbCountry.getSelectionModel().selectedItemProperty().addListener( e -> {
           String selectedCountry = cbCountry.getSelectionModel().getSelectedItem();
           btnRemoveCountry.setDisable(selectedCountry == null);
           lblCountry.setText(selectedCountry == null? "..." : selectedCountry);
       });

    }
    @FXML
    void txtCountryOnAction(ActionEvent event) {
    String country = txtCountry.getText().strip();
    if(country.isEmpty()){
        new Alert(Alert.AlertType.ERROR,"Country can't be empty").show();
        txtCountry.selectAll();
        return;
    }
        ObservableList<String> countryList = cbCountry.getItems();
        if(countryList.contains(country)){
            new Alert(Alert.AlertType.ERROR,"Country already exist. Try something new!").show();
            txtCountry.selectAll();
            return;
        }
        countryList.add(country);
        txtCountry.clear();
    }

    @FXML
    void btnClearCountryOnAction(ActionEvent event) {
    ObservableList<String> countryList = cbCountry.getItems();
    countryList.clear();
    txtCountry.requestFocus();
    }

    @FXML
    void btnRemoveCountryOnAction(ActionEvent event) {
    cbCountry.getItems().remove(cbCountry.getSelectionModel().getSelectedItem());

    }

    @FXML
    void cbCountryOnAction(ActionEvent event) {
    //lblCountry.setText(cbCountry.getSelectionModel().getSelectedItem());
    }

    @FXML
    void cbCountryOnKeyPressed(KeyEvent e) {
    if(e.getCode() == KeyCode.DELETE) btnRemoveCountry.fire();
    }

    @FXML
    void rootOnKeyPressed(KeyEvent e) {
    if(e.getCode() == KeyCode.F12) btnClearCountry.fire();
    }
}
