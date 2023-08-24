package lk.ijse.dep11;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Scene3Controller {
    public Button btnGoToScene1;
    public Button btnGoToScene2;
    public AnchorPane root;

    public void btnGoToScene1OnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/View/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene1);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();

        TranslateTransition translate = new TranslateTransition(Duration.millis(500), scene1Root);
        translate.setFromX(-250);
        translate.setToX(0);
        translate.playFromStart();
    }

    public void btnGoToScene2OnAction(ActionEvent actionEvent) throws Exception{
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
}
