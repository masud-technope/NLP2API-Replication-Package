import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
//from  w  w w.  java  2  s . c o m
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;

public class Main {

  public static void main(String[] args) throws Exception {
    String html = "<h1>Hello, world.</h1>";
    int width = 200, height = 100;

    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getDefaultScreenDevice().getDefaultConfiguration()
        .createCompatibleImage(width, height);

    Graphics graphics = image.createGraphics();

    JEditorPane jep = new JEditorPane("text/html", html);
    jep.setSize(width, height);
    jep.print(graphics);

    ImageIO.write(image, "png", new File("Image.png"));
  }
}