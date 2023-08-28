package lk.ijse.dep11;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainViewController {
    public Slider slrRed;
    public Slider slrGreen;
    public Slider slrBlue;
    public Slider slrAlpha;
    public Slider slrOpacity;
    public Rectangle shpRec;
    public Label lblRed;
    public Label lblOpacity;
    public Label lblGreen;
    public Label lblBlue;
    public AnchorPane root;

    public void initialize() {
        lblRed.setTooltip(new Tooltip("RED Value"));
        lblGreen.setTooltip(new Tooltip("GREEN Value"));
        lblBlue.setTooltip(new Tooltip("BLUE Value"));
        lblOpacity.setTooltip(new Tooltip("ALPHA Value"));
        //txtColor.setTooltip(new Tooltip("COLOR code"));

        slrRed.valueProperty().addListener(e -> {
            lblRed.setText(String.format("%.0f", slrRed.getValue()));
            updateColor();
        });
        slrGreen.valueProperty().addListener(e -> {
            lblGreen.setText(String.format("%.0f", slrGreen.getValue()));
            updateColor();
        });
        slrBlue.valueProperty().addListener(e -> {
            lblBlue.setText(String.format("%.0f", slrBlue.getValue()));
            updateColor();
        });
        slrAlpha.valueProperty().addListener(e -> {
            lblOpacity.setText(String.format("%.0f", slrAlpha.getValue()));
            updateColor();
        });
    }

    void updateColor() {
        int red = Integer.parseInt(lblRed.getText());
        int green = Integer.parseInt(lblGreen.getText());
        int blue = Integer.parseInt(lblBlue.getText());
        int alpha = Integer.parseInt(lblOpacity.getText());
        Color colorRef = Color.rgb(red, green, blue, alpha / 255.0);
        shpRec.setFill(colorRef);
        //txtColor.setText("#" + colorRef.toString().substring(2).toUpperCase());
    }
}