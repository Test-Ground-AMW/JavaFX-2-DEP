package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.tm.Customer;

public class MainViewController {
    public AnchorPane root;
    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;
    public Button btmDelete;
    public TableView<Customer> tblCustomers;
    public Button btnNewCustomer;

    public void initialize(){
        /*Column Mapping*/
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        btmDelete.setDisable(true);

//        tblCustomers.getSelectionModel().selectedItemProperty().addListener(e ->{
//            Customer getID = tblCustomers.getSelectionModel().getSelectedItem();
//            btmDelete.setDisable(getID == null);
//            txtID.setText(Integer.toString(tblCustomers.getSelectionModel().getSelectedItem().getId()));
//            txtName.setText(tblCustomers.getSelectionModel().getSelectedItem().getName());
//            txtAddress.setText(tblCustomers.getSelectionModel().getSelectedItem().getAddress());
//        });

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((value,previous,current) -> {
            btmDelete.setDisable(current == null);
            txtID.setText(current.getId()+"");
            txtName.setText(current.getName());
            txtAddress.setText(current.getAddress());
        });

    }

    boolean isDigit(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) return false;
        }
        return true;
    }
    public void btnSaveOnAction(ActionEvent actionEvent) {

        if(txtID.getText().isEmpty() || !isDigit(txtID.getText().strip())){
            txtID.requestFocus();
            txtID.selectAll();
            return;
        } else if (txtName.getText().isEmpty()) {
            txtName.requestFocus();
            txtName.selectAll();
            return;
        } else if (txtAddress.getText().isEmpty()){
            txtAddress.requestFocus();
            txtAddress.selectAll();
            return;
        }

        int id = Integer.parseInt(txtID.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        Customer newCustomer = new Customer(id,name,address);
        ObservableList<Customer> customerList = tblCustomers.getItems();

        for(Customer customer : customerList){
            if(customer.getId()==id){
                new Alert(Alert.AlertType.ERROR,"ID "+id+" already exist!").show();
                txtID.requestFocus();
                txtID.selectAll();
                return;
            }
        }
        customerList.add(newCustomer);
        btnNewCustomer.fire();
    }

    public void btmDeleteOnAction(ActionEvent actionEvent) {
        Customer selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();
        ObservableList<Customer> customerList = tblCustomers.getItems();
        customerList.remove(selectedCustomer);
        if(customerList.isEmpty()) btnNewCustomer.fire();

    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtID.requestFocus();
    }
}
