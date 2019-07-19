import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
//from  ww  w.  j  a  va2s. co  m
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedImage image = ImageIO.read(new URL(
            "http://www.java2s.com/style/download.png"));
        System.out.println(image == null);
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println(width + "x" + height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.printf("%04X ", image.getRGB(col, row));
            }
            System.out.println();
        }
    }
}
