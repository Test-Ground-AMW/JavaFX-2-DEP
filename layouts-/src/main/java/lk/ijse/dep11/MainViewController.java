package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.security.cert.Extension;

public class MainViewController {

    public Button btnBorderPaneLayout;
    public Button btnFlowPaneLayout;
    public Button btnTilePaneLayout;
    public Button btnGridPaneLayout;
    public Button btnStackPaneLayout;
    public Button btnTabPaneLayout;
    @FXML
    private Button btnAcchorPaneLayout;
    @FXML
    private Button btnBringToFront;

    @FXML
    private Circle shpCircle;

    @FXML
    private Rectangle shpRectangle;

    @FXML
    void btnBringToFrontOnAction(ActionEvent event) {

    }


    @FXML
    void btnAcchorPaneLayoutOnAction(ActionEvent event) throws  Exception {
        AnchorPane anchorPaneRoot = FXMLLoader.load(getClass().getResource("/view/AnchorPaneLayoutScene.fxml"));
        Scene mainScene = new Scene(anchorPaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Anchor Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnBorderPaneLayoutOnAction(ActionEvent actionEvent) throws Exception{
        BorderPane borderPaneRoot = FXMLLoader.load(getClass().getResource("/view/BorderPaneLayoutScene.fxml"));
        Scene mainScene = new Scene(borderPaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Border Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnFlowPaneLayoutOnAction(ActionEvent actionEvent) throws Exception{
        FlowPane flowPaneRoot = FXMLLoader.load(getClass().getResource("/view/FlowPaneLayoutScene.fxml"));
        Scene mainScene = new Scene(flowPaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Flow Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnTilePaneLayoutOnAction(ActionEvent actionEvent) throws Exception{
        TilePane tilePaneRoot = FXMLLoader.load(getClass().getResource("/view/TilePaneLayoutScene.fxml"));
        Scene mainScene = new Scene(tilePaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Tile Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnGridPaneLayoutOnAction(ActionEvent actionEvent) throws Exception {
        GridPane gridPaneRoot = FXMLLoader.load(getClass().getResource("/view/GridPaneLayoutScene.fxml"));
        Scene mainScene = new Scene(gridPaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Grid Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnStackPaneLayouOnAction(ActionEvent actionEvent) throws Exception{
        StackPane stackPaneRoot = FXMLLoader.load(getClass().getResource("/view/StackPaneLayoutScene.fxml"));
        Scene mainScene = new Scene(stackPaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Stack Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnTabPaneLayoutOnAction(ActionEvent actionEvent) throws Exception{
        TabPane tabPaneRoot = FXMLLoader.load(getClass().getResource("/view/TabPaneLayoutScene.fxml"));
        Scene mainScene = new Scene(tabPaneRoot);
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("Tab Pane");
        stage.centerOnScreen();
        stage.show();
    }
}
