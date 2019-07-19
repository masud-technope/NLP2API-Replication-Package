import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.WHITE);

        Ellipse bigCircle = EllipseBuilder.create()
                .centerX(100)
                .centerY(100)
                .radiusX(50)
                .radiusY(75/2)
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .fill(Color.WHITE)
                .build();
        
        Ellipse smallCircle = EllipseBuilder.create()
                .centerX(100)
                .centerY(100)
                .radiusX(35/2)
                .radiusY(25/2)
                .build();

        Shape shape = Path.subtract(bigCircle, smallCircle);
        shape.setStrokeWidth(1);
        shape.setStroke(Color.BLACK);

        shape.setFill(Color.rgb(255, 200, 0));

        DropShadow dropShadow = DropShadowBuilder.create()
            .offsetX(2.0f)
            .offsetY(2.0f)
            .color(Color.rgb(50, 50, 50, .588))
            .build();
        shape.setEffect(dropShadow);
        
        root.getChildren().add(shape);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
