import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Label msg = new Label("java2s.com");
        msg.setStyle("-fx-text-fill: blue;");
        
        VBox root = new VBox();
        root.getChildren().add(msg);

        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX Application with a Scene");
        stage.show();
    }
}