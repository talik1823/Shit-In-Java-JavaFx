import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends  Application{
    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = (Parent) FXMLLoader.load(getClass().getResource("tamplate.fxml"));
//        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Chaser.fxml"));
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("squreOrder.fxml"));
        Scene scene = new Scene(root);
//        stage.setTitle("calcolateGame");
//        stage.setTitle("mouseDragging");
        stage.setTitle("squareClicks");
        stage.setScene(scene);
        stage.show();

    }
}
