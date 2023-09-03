package lk.ise.dep11;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MainViewController {
    public Label lblDragMe;

    static double x = 0;
    static double y = 0;
    static double lbx = 0;
    static double lby = 0;
    public Rectangle shpRec;

    public void lblDragMeOnMouseDragged(MouseEvent e) {
//        lblDragMe.setLayoutX(e.);
    }

    public void lblDragMeOnMousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        lbx = e.getSceneX();
        lby = e.getSceneY();
    }

    public void lblDragMeOnMouseReleased(MouseEvent e) {
        if(lbx>263 && lbx<463 && lby>38 && lby<388) {
            lblDragMe.setLayoutX(e.getSceneX() - x);
            lblDragMe.setLayoutY(e.getSceneY() - y);
        } else {
            lblDragMe.setLayoutX(x);
            lblDragMe.setLayoutY(y);
        }
    }
}
