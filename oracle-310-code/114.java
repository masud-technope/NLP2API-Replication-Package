import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
//from  www. j  av a 2  s. c o m
import javax.imageio.ImageIO;

public class Main {
  public static void main(String arg[]) throws Exception {

    String yourText = "java2s.com";
    BufferedImage bufferedImage = new BufferedImage(170, 30,
        BufferedImage.TYPE_INT_RGB);
    
    Graphics graphics = bufferedImage.getGraphics();
    graphics.setColor(Color.LIGHT_GRAY);
    graphics.fillRect(0, 0, 200, 50);
    graphics.setColor(Color.BLACK);
    graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
    graphics.drawString(yourText, 10, 25);
    
    ImageIO.write(bufferedImage, "jpg", new File(
        "C:/Users/image.jpg"));
    
    System.out.println("Image Created");
  }
}