import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
//from  w  ww . j ava2  s  .  c om
public class Main extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage) {
    Text msg = new Text("java2s.com");
    msg.setTextOrigin(VPos.TOP);
    msg.setFont(Font.font(24));

    Pane root = new Pane(msg);
    root.setPrefSize(500, 70);
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.setTitle("Scrolling Text");
    stage.show();

    double sceneWidth = scene.getWidth();
    double msgWidth = msg.getLayoutBounds().getWidth();

    KeyValue initKeyValue = new KeyValue(msg.translateXProperty(), sceneWidth);
    KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

    KeyValue endKeyValue = new KeyValue(msg.translateXProperty(), -1.0
        * msgWidth);
    KeyFrame endFrame = new KeyFrame(Duration.seconds(3), endKeyValue);

    Timeline timeline = new Timeline(initFrame, endFrame);

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }
}
