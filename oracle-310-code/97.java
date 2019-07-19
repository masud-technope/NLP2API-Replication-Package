import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//w  w  w. j a  va  2  s.c o  m
import javax.imageio.ImageIO;

public class Main {
  public void createThumbnail(File file) throws Exception {
    BufferedImage img = ImageIO.read(file);
    BufferedImage thumb = new BufferedImage(100, 200,
        BufferedImage.TYPE_INT_RGB);

    Graphics2D g2d = (Graphics2D) thumb.getGraphics();
    g2d.drawImage(img, 0, 0, thumb.getWidth() - 1, thumb.getHeight() - 1, 0, 0,
        img.getWidth() - 1, img.getHeight() - 1, null);
    g2d.dispose();
    ImageIO.write(thumb, "PNG", new File("thumb.png"));
  }
}