package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {

    public Button btnApplicationModel;
    @FXML
    private Button btnNextStage;

    @FXML
    private Button btnWindowModel;

    @FXML
    private AnchorPane root;

    @FXML
    void btnNextStageOnAction(ActionEvent event) throws Exception{
        AnchorPane mainSceneRoot = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
        Scene mainScene = new Scene(mainSceneRoot);
        Stage stage = new Stage();
    stage.setScene(mainScene);
    stage.setTitle("New Stage");
    stage.show();
    }

    @FXML
    void btnWindowModelOnAction(ActionEvent event) throws Exception{
    AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/View/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());
        stage.setScene(scene1);
        stage.setTitle("New model window");
        stage.show();
    }

    public void btnApplicationModelOnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/View/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene1);
        stage.setTitle("New model window");
        stage.show();
    }
}
