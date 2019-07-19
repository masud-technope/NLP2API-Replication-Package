import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageConverterGIF {
  public static void main(String[] args) throws Exception {
    String imageFilePath = "C:/myBmp.bmp";
    String gifFilePath = "C:/myPic.gif";
    File inputFile = new File(imageFilePath);
    BufferedImage image = ImageIO.read(inputFile);
    File outputFile = new File(gifFilePath);
    ImageIO.write(image, "GIF", outputFile);
  }
}
