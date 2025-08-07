import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class squareClicks {

    @FXML
    private Canvas canv1;

    @FXML
    private Canvas canv2;
    
    private GraphicsContext gc1, gc2;
    private ArrayList<Rectangle> r1,r2;

    private final int MIN_SIZE = 20;
    private final int AMOUNT = 5;


    public void initialize() {
        r1 = new ArrayList<>();
        r2 = new ArrayList<>();
        gc1 = canv1.getGraphicsContext2D();
        gc2 = canv2.getGraphicsContext2D();
        createRectangle(r1);
        printRectangle();
    }

    private void createRectangle(ArrayList<Rectangle> r) {
        Random rnd  = new Random();
        int width;

        for(int i = 0; i < AMOUNT; i++) {
            width = rnd.nextInt(81) + MIN_SIZE;
            r.add( new Rectangle( rnd.nextInt(300), rnd.nextInt(150), width, width));
        }

    }

    private void printRectangle() {
        gc1.clearRect(0,0,canv1.getWidth(),canv1.getHeight());
        gc2.clearRect(0,0,canv2.getWidth(),canv2.getHeight());

        drawRectOnCanvas(gc1, r1);
        drawRectOnCanvas(gc2, r2);
    }

    private void drawRectOnCanvas(GraphicsContext gc, ArrayList<Rectangle> r) {
        for( Rectangle lt : r) {
            gc.strokeRect( lt.getX(), lt.getY(), lt.getWidth(), lt.getHeight());
        }
    }


    private Rectangle getSmallestRect() {
        if(r1.isEmpty())
            return null;

        Rectangle smallest = r1.getLast();
        for(Rectangle rectangle: r1) {
            if ( rectangle.getWidth() < smallest.getWidth() )
                smallest = rectangle;
        }
        return smallest;
    }

    private void transfer( Rectangle r ) {
        r1.remove(r);
        r.setX(20);
        r.setY(20);
        r2.add(r);
    }

    @FXML
    void poMouseClick(MouseEvent event) {
        Rectangle smallest = getSmallestRect();

        if( smallest.contains( event.getX(), event.getY()) ) {
            transfer(smallest);
            printRectangle();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Not Valid");
            alert.setHeaderText("This Rectangle is not the smallest rectangle in the canvas.");
            alert.setContentText(null);
            alert.show();
        }
    }

}
