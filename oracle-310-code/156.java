import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class Main {
  public static void main(String[] argv) throws Exception {
    File file = new File("image.gif");
    System.out.println(getFormatName(file));

    InputStream is = new FileInputStream(file);
    is.close();
    System.out.println(getFormatName(is));
  }
  private static String getFormatName(Object o) {
    try {
      ImageInputStream iis = ImageIO.createImageInputStream(o);
      Iterator iter = ImageIO.getImageReaders(iis);
      if (!iter.hasNext()) {
        return null;
      }
      ImageReader reader = (ImageReader) iter.next();
      iis.close();

      return reader.getFormatName();
    } catch (IOException e) {
    }
    return null;
  }
}