import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/*from w ww . ja v  a  2s . co m*/
import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedImage image = ImageIO.read(new File("E:/Java_Dev/plasma.gif"));

    // crop image
    BufferedImage firstHalf = image.getSubimage(0, 0, (image.getWidth() / 2),
        image.getHeight());
    BufferedImage secondHalf = image.getSubimage(image.getWidth() / 2, 0,
        image.getWidth() / 2, image.getHeight());

    File croppedFile1 = new File("E:/Java_Dev/half1.png");
    File croppedFile2 = new File("E:/Java_Dev/half2.png");

    ImageIO.write(firstHalf, "png", croppedFile1);
    ImageIO.write(secondHalf, "png", croppedFile2);

    // join image
    BufferedImage joined = new BufferedImage(image.getWidth(),
        image.getHeight(), image.getType());
    BufferedImage image1 = ImageIO.read(new File("E:/Java_Dev/half1.png"));
    BufferedImage image2 = ImageIO.read(new File("E:/Java_Dev/half2.png"));

    Graphics2D graph = joined.createGraphics();
    graph.drawImage(image1, 0, 0, null);
    graph.drawImage(image2, image1.getWidth(), 0, null);

    File joinedFile = new File("E:/Java_Dev/joined.png");
    ImageIO.write(joined, "png", joinedFile);
  }
}
