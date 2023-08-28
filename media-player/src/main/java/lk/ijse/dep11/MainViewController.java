package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class MainViewController {

    public MediaView mvMain;
    @FXML
    private Button btnBrowsAudio;

    @FXML
    private Button btnBrowsVideo;

    @FXML
    private Button btnPlayAudio;

    @FXML
    private Button btnPlayVideo;

    @FXML
    private Button btnStopAudio;

    @FXML
    private Button btnStopVideo;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAudioPath;

    @FXML
    private TextField txtVideoPath;
    MediaPlayer audioPlayer;
    MediaPlayer videoPlayer;

    @FXML
    void btnBrowsAudioOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Mp3 files","*.mp3"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("wave files","*.wav"));
        File audioFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(audioFile != null){
            txtAudioPath.setText(audioFile.getAbsolutePath());
            Media media = new Media(audioFile.toURI().toString());

            audioPlayer = new MediaPlayer(media);

        } else {
            txtAudioPath.clear();
        }
    }

    @FXML
    void btnBrowsVideoOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video files","*.mp4","*.avi","*.mkv"));
        File videoFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(videoFile != null){
            txtVideoPath.setText(videoFile.toURI().toString());
            Media media = new Media(videoFile.toURI().toString());

            videoPlayer = new MediaPlayer(media);
        } else {
            txtVideoPath.clear();
        }
    }


    @FXML
    void btnPlayVideoOnAction(ActionEvent event) {
    if(videoPlayer != null){
        mvMain.setMediaPlayer(videoPlayer);
        videoPlayer.play();
    }
    }

    @FXML
    void btnPlayAudioOnAction(ActionEvent event) {
        if(audioPlayer != null) audioPlayer.play();
    }


    @FXML
    void btnStopAudioOnAction(ActionEvent event) {
    if (audioPlayer != null) audioPlayer.stop();
    }

    @FXML
    void btnStopVideoOnAction(ActionEvent event) {
    if(videoPlayer != null){
        mvMain.setMediaPlayer(null);
        videoPlayer.stop();
    }
    }

}
