package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainViewController {
    public TextField txtFolderPath;
    public Button btnBrowse;
    public ProgressBar pbLoader;
    public TilePane tlpImageContainer;
    public AnchorPane root;

    public void initialize(){
        tlpImageContainer.prefWidthProperty().bind(root.widthProperty());
        tlpImageContainer.prefHeightProperty().bind(root.heightProperty());
    }

    public void btnBrowseOnAvtion(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select an Image file");
        File dir = directoryChooser.showDialog(root.getScene().getWindow());

        if(dir == null) {
            txtFolderPath.clear();
        } else {
            txtFolderPath.setText(dir.getAbsolutePath());
            File[] files = dir.listFiles();
            ArrayList<File> imageFileList = new ArrayList<>();
            for (File file: files) {
                if(!file.isFile()||!isImageFile(file.getAbsolutePath())) continue;
                System.out.println(file);
                imageFileList.add(file);
            }
            Platform.runLater(()->{
                tlpImageContainer.getChildren().clear();

                for (File imageFiles:imageFileList) {
                    Image image = new Image(imageFiles.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(250);
                    imageView.setFitHeight(250);
                    tlpImageContainer.getChildren().add(imageView);
                }
                pbLoader.setVisible(true);
            });
        }
    }
    public boolean isImageFile(String filePath) {
        String[] ext = {".jpeg",".jpg",".png",".gif",".bmp"};
        for (String extensions:ext) {
            if(filePath.endsWith(extensions)) return true;
        }
        return false;
    }
}
