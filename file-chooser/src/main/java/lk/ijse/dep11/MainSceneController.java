package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;

public class MainSceneController {
    public AnchorPane root;
    public TextField txtFilePath;
    public Button btnBrows;
    public ImageView ivMain;

    public void btnBrowsOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.txt"));
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.jpeg","*.jpg","*.png","*.gif","*.bmp"));
       // fileChooser.setInitialDirectory(new file("/<path>"))
        fileChooser.setTitle("Select an Image file");

        //showSaveDialog
        //showOpenDialog
        //showMultipleDialog

        File imageFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (imageFile != null){
            txtFilePath.setText(imageFile.getAbsolutePath());
            Image image = new Image(imageFile.toURI().toString());
            ivMain.setImage(image);

        }else{
            txtFilePath.clear();
            ivMain.setImage(null);
        }
    }
}
