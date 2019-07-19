import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.net.URL;
/*  w w  w. j a v a2s . c  om*/
import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedImage master = ImageIO.read(new URL(
        "http://www.java2s.com/style/download.png"));
    BufferedImage gray = new BufferedImage(master.getWidth(),
        master.getHeight(), BufferedImage.TYPE_INT_ARGB);

    ColorConvertOp op = new ColorConvertOp(
        ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    op.filter(master, gray);

    // new JLabel(new ImageIcon(master));
    // new JLabel(new ImageIcon(gray));
    ImageIO.write(master, "png", new File("c:/Java_Dev/master.png"));
    ImageIO.write(gray, "png", new File("c:/Java_Dev/gray.png"));
  }
}
