import javafx.css.Size;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class calcolateGame {

    @FXML
    private GridPane grid;
    private Button[] bfs;
    private int counter = 0;
    private Button first, second, third;
    final int SIZE = 5;

    public void initialize () {
        bfs = new Button[SIZE * SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            bfs[i] = new Button(i + 1 + "");
            bfs[i].setPrefSize(grid.getPrefWidth() / SIZE, grid.getPrefHeight() / SIZE);
            grid.add(bfs[i], i % SIZE, i / SIZE);

            bfs[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    handlerBoutton(event);
                }

            });
        }
    }

    private void handlerBoutton(ActionEvent event) {

        if (first == null)
            first = (Button) event.getSource();
        else if (second == null)
            second = (Button) event.getSource();
        else {
            third = (Button) event.getSource();
            int num1 = Integer.parseInt(first.getText());
            int num2 = Integer.parseInt(second.getText());
            int num3 = Integer.parseInt(third.getText());

            if(num1 + num2 == num3) {
                disableButton();
                counter++;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failed");
                alert.setHeaderText(null);
                alert.setContentText("Error");
                alert.showAndWait();
            }
            first = null;
            second = null;
            third = null;
        }
    }


    private void disableButton() {
        first.setDisable( true);
        second.setDisable( true);
        third .setDisable( true);
        first.setText("");
        second.setText("");
        third.setText("");
    }


    @FXML
    void finishCalc(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Score Report");
        alert.setContentText("Your score is " + counter +" correct exercises");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}
