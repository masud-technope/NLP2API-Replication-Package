import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
/* w  w  w  .j  ava  2  s  .  c o m*/
import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedImage originalImage = ImageIO.read(new File("test.png"));
    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
        : originalImage.getType();

    BufferedImage resizeImageBmp = resizeImage(originalImage, type);
    ImageIO.write(resizeImageBmp, "png", new File("a.png"));

    resizeImageBmp = resizeImageWithHint(originalImage, type);
    ImageIO.write(resizeImageBmp, "png", new File("b.png"));

  }

  private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
    int IMG_WIDTH = 512;
    int IMG_CLAHEIGHT = 512;
    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_CLAHEIGHT,
        type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_CLAHEIGHT, null);
    g.dispose();
    return resizedImage;
  }

  private static BufferedImage resizeImageWithHint(BufferedImage originalImage,
      int type) {
    int IMG_WIDTH = 512;
    int IMG_CLAHEIGHT = 512;
    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_CLAHEIGHT,
        type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_CLAHEIGHT, null);
    g.dispose();
    g.setComposite(AlphaComposite.Src);

    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    return resizedImage;
  }
}

