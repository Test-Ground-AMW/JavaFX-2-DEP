package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class MainViewController {
    public AnchorPane root;
    public Label lblValue;
    public Button btnStart;
    public ProgressBar pb1;
    public ProgressBar pb2;
    public Button btnSystemExit;
    public Button btnPlatformExit;

    public void btnStartOnAction(ActionEvent actionEvent) throws InterruptedException {
        Task<Void> myLongRunningTask = new Task<>(){

            @Override
            protected Void call() throws Exception {
                // time consume task defining

                Platform.runLater(()->pb1.setProgress(0));
                for (int i = 0; i < 50; i++) {
                    System.out.println("DEP "+ i );
                    int k = i;
                    Platform.runLater(() -> {
                        lblValue.setText("Value: " + String.format("%.0f",(k/50.0*100)).concat("%"));
                        pb1.setProgress(k/50.0);
                    });
                    Thread.sleep(100);
                }
                Platform.runLater(() -> {
                    lblValue.setText("Value: 100%");
                });
                pb1.setProgress(1);

                return null;
            }
        };
            new Thread(myLongRunningTask).start();   // to execute the long-running task

    }

    public void btnSystemExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void btnPlatformExitOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }
}
