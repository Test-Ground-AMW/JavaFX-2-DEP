package lk.ijse.dep11;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class MainViewController {
    public AnchorPane root;
    public Button btnFadeIn;
    public Button btnFadeOut;
    public Circle shpFade;
    public Spinner<Integer> txtRotate;
    public Button btnRotate;
    public Rectangle shpRotate;
    public Spinner<Double> txtScale;
    public Button btnScale;
    public Circle shpScale;
    public ComboBox<String> cbTranslate;
    public Button btnTranslate;
    public Rectangle shpTranslate;
    public ColorPicker clrFrom;
    public ColorPicker clrTo;
    public Circle shpFill;
    public Button btnFill;
    public ColorPicker clrFromStroke;
    public ColorPicker clrToStroke;
    public Button btnStroke;
    public Rectangle shpStroke;

    public void initialize(){
        txtRotate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-360,360));
        txtRotate.getValueFactory().setValue(0);

        //min,max,initial value,step
        txtScale.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-0.5,2.5,1.0,0.1));

        cbTranslate.getItems().add("SlideInLeft");
        cbTranslate.getItems().add("SlideInRight");
        cbTranslate.getItems().add("SlideInTop");
        cbTranslate.getItems().add("SlideInBottom");
        cbTranslate.getItems().add("SlideOutLeft");
        cbTranslate.getItems().add("SlideOutRight");
        cbTranslate.getItems().add("SlideOutTop");
        cbTranslate.getItems().add("SlideOutBottom");
        cbTranslate.setValue(cbTranslate.getItems().get(0));

    }
    // Fade in (Hide -> Show)
    public void btnFadeInOnAction(ActionEvent actionEvent) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), shpFade);
        fadeIn.setByValue(0);   // Opacity value
        fadeIn.setToValue(1);
        fadeIn.playFromStart();
    }

    // Fade out (Show -> Hide)
    public void btnFadeOutOnAction(ActionEvent actionEvent) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), shpFade);
        fadeOut.setByValue(1);   // Opacity value
        fadeOut.setToValue(0);
        fadeOut.playFromStart();

    }

    public void btnRotateOnAction(ActionEvent actionEvent) {
        RotateTransition rotate = new RotateTransition(Duration.millis(500), shpRotate);
        rotate.setFromAngle(0);
        rotate.setToAngle(txtRotate.getValue());
        rotate.playFromStart();

    }

    public void btnScaleOnAcrion(ActionEvent actionEvent) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(500),shpScale);
        scale.setFromX(0);
        scale.setFromY(0);
        scale.setToX(txtScale.getValue());
        scale.setByY(txtScale.getValue());
        scale.playFromStart();
    }

    public void btnTranslateOnAction(ActionEvent actionEvent) {
        TranslateTransition translate = new TranslateTransition(Duration.millis(500), shpTranslate);
        shpTranslate.setLayoutX(75);
        shpTranslate.setLayoutY(119);
        switch (cbTranslate.getValue()){
            case "SlideInLeft":
                translate.setFromX(-250);
                translate.setToX(0);
                break;
            case "SlideInRight":
                translate.setFromX(250);
                translate.setToX(0);
                break;
            case "SlideInTop":
                translate.setFromY(-250);
                translate.setToY(0);
                break;
            case "SlideInBottom":
                translate.setToY(250);
                translate.setToY(0);
                break;
            case "SlideOutLeft":
                translate.setFromX(0);
                translate.setFromY(0);
                translate.setToX(-250);
                break;
            case "SlideOutRight":
                translate.setFromX(0);
                translate.setFromY(0);
                translate.setToX(250);
                break;
            case "SlideOutTop":
                translate.setFromY(0);
                translate.setFromX(0);
                translate.setToY(-250);
                break;
            case "SlideOutBottom":
                translate.setFromY(0);
                translate.setFromX(0);
                translate.setToY(250);
                break;
        }
        translate.playFromStart();

    }
    @FXML
    void btnFillOnAction(ActionEvent event) {
        FillTransition fill = new FillTransition(Duration.millis(500),shpFill);
        fill.setFromValue(clrFrom.getValue());
        fill.setToValue(clrTo.getValue());
        fill.playFromStart();
    }
    @FXML
    void btnStrokeOnAction(ActionEvent event) {
        StrokeTransition stroke = new StrokeTransition(Duration.millis(500), shpStroke);
        stroke.setFromValue(clrFromStroke.getValue());
        stroke.setToValue(clrToStroke.getValue());
        stroke.playFromStart();

    }
}
