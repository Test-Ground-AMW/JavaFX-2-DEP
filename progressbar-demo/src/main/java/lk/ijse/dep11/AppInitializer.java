package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("About to start JRE");
        launch(args);
        System.out.println("Just exit from JRE");
    }

    @Override
    public void start(Stage primaryStage)throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Progress bar");
        primaryStage.centerOnScreen();
        primaryStage.show();

        primaryStage.setOnCloseRequest( e ->{
          Optional<ButtonType> button =  new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure To Exit?", ButtonType.YES,ButtonType.NO).showAndWait();
          if (button.get()==ButtonType.NO){
              e.consume();
          }
        });
    }
}
