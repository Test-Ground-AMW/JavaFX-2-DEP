package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AnchorPaneLayoutController {

    public AnchorPane root;
    @FXML
    private Button btnClickMe;

    @FXML
    void btnClickMeOnAction(ActionEvent event) {
        double x = Math.random() * root.getWidth();
        double y = Math.random() * root.getHeight();
    btnClickMe.setLayoutX(x);
    btnClickMe.setLayoutY(y);
    }

}
