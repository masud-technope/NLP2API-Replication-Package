import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
//from  w w  w. j av a2 s. c o  m
public class Main extends Application {

  double orgSceneX, orgSceneY;

  private Circle createCircle(double x, double y, double r, Color color) {
    Circle circle = new Circle(x, y, r, color);

    circle.setCursor(Cursor.HAND);

    circle.setOnMousePressed((t) -> {
      orgSceneX = t.getSceneX();
      orgSceneY = t.getSceneY();

      Circle c = (Circle) (t.getSource());
      c.toFront();
    });
    circle.setOnMouseDragged((t) -> {
      double offsetX = t.getSceneX() - orgSceneX;
      double offsetY = t.getSceneY() - orgSceneY;

      Circle c = (Circle) (t.getSource());

      c.setCenterX(c.getCenterX() + offsetX);
      c.setCenterY(c.getCenterY() + offsetY);

      orgSceneX = t.getSceneX();
      orgSceneY = t.getSceneY();
    });
    return circle;
  }

  private Line connect(Circle c1, Circle c2) {
    Line line = new Line();

    line.startXProperty().bind(c1.centerXProperty());
    line.startYProperty().bind(c1.centerYProperty());

    line.endXProperty().bind(c2.centerXProperty());
    line.endYProperty().bind(c2.centerYProperty());

    line.setStrokeWidth(1);
    line.setStrokeLineCap(StrokeLineCap.BUTT);
    line.getStrokeDashArray().setAll(1.0, 4.0);

    return line;
  }

  @Override
  public void start(Stage primaryStage) {
    Group root = new Group();
    Scene scene = new Scene(root, 500, 260);

    // circles
    Circle redCircle = createCircle(100, 50, 30, Color.RED);
    Circle blueCircle = createCircle(20, 150, 20, Color.BLUE);
    Circle greenCircle = createCircle(40, 100, 40, Color.GREEN);

    Line line1 = connect(redCircle, blueCircle);
    Line line2 = connect(redCircle, greenCircle);
    Line line3 = connect(greenCircle, blueCircle);

    // add the circles
    root.getChildren().add(redCircle);
    root.getChildren().add(blueCircle);
    root.getChildren().add(greenCircle);

    // add the lines
    root.getChildren().add(line1);
    root.getChildren().add(line2);
    root.getChildren().add(line3);

    // bring the circles to the front of the lines
    redCircle.toFront();
    blueCircle.toFront();
    greenCircle.toFront();

    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
