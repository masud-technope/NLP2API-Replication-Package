import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
// w ww. ja va  2 s.c  om
import javax.imageio.ImageIO;

public class Main {

  public static void main(String[] args) throws IOException {
    String url = "http://www.java2s.com/style/download.png";
    String text = "java2s.com";
    byte[] b = mergeImageAndText(url, text, new Point(200, 200));
    FileOutputStream fos = new FileOutputStream("new.png");
    fos.write(b);
    fos.close();
  }

  public static byte[] mergeImageAndText(String imageFilePath, String text,
      Point textPosition) throws IOException {
    
    BufferedImage im = ImageIO.read(new URL(imageFilePath));
    Graphics2D g2 = im.createGraphics();
    g2.drawString(text, textPosition.x, textPosition.y);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(im, "png", baos);
    
    return baos.toByteArray();
  }
}