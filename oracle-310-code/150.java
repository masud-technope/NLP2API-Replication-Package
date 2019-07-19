import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {
  public static void main(String[] argv) throws Exception {
    Robot robot = new Robot();
    
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
  }
}
