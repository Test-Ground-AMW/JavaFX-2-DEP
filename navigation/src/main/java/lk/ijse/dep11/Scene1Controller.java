package lk.ijse.dep11;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Scene1Controller {
    public Button btnGoToScene2;
    public Button btnGoToScene3;
    public AnchorPane root;
    public Button btnOpenInNewStage;

    public void btnGoToScene2OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene2Root = FXMLLoader.load(getClass().getResource("/View/Scene2.fxml"));
        Scene scene2 = new Scene(scene2Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();

        TranslateTransition translate = new TranslateTransition(Duration.millis(500), scene2Root);
        translate.setFromX(-250);
        translate.setToX(0);
        translate.playFromStart();

    }

    public void btnGoToScene3OnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane scene3Root = FXMLLoader.load(getClass().getResource("/View/Scene3.fxml"));
        Scene scene3 = new Scene(scene3Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene3);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();

        TranslateTransition translate = new TranslateTransition(Duration.millis(500), scene3Root);
        translate.setFromX(-250);
        translate.setToX(0);
        translate.playFromStart();
    }

    public void btnOpenInNewStageOnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/View/Scene1.fxml"));
        Scene scene = new Scene(scene1Root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("This is a new Stage");
        stage.show();

    }
}
