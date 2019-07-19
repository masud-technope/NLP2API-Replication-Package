import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
/*from w  ww. j  av a 2s  . c  o m*/
import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] args) throws java.io.IOException {
    BufferedImage img = ImageIO.read(new File("input-image.png"));

    BufferedImage rotated = new AffineTransformOp(
        AffineTransform.getQuadrantRotateInstance(3, img.getWidth() / 2,
            img.getHeight() / 2), AffineTransformOp.TYPE_BILINEAR).filter(img,
        null);

    ImageIO.write(rotated, "PNG", new File("output-image.png"));
  }
}
