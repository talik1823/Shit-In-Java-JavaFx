import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;

public class mouseDragging {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;

    public void initialize() {
        gc = canv.getGraphicsContext2D();
    }

    @FXML
    void clearBoard(ActionEvent event) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0, canv.getWidth(), canv.getHeight());
    }

    @FXML
    void mosClicked(MouseEvent event) {
        drawText("Clicked", event, Color.RED);
    }

    @FXML
    void mosDragged(MouseEvent event) throws InterruptedException {
        drawText("Dragged", event, Color.AQUA);
    }

    @FXML
    void mosMoves(MouseEvent event) {
        drawText("Moves", event, Color.GREEN);

    }

    private void drawText(String text, MouseEvent event , Color col) {
        gc.clearRect(0,0, canv.getWidth(),canv.getHeight());
        gc.setFill(col);
        double x = event.getX();
        double y = event.getY();

        gc.fillRect(x-25, y-25,  50,  50);
//        gc.strokeText(text, event.getX(), event.getY());
    }

}
