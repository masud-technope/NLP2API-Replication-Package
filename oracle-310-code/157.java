import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Locale;
/*  w  w  w .  ja  v  a2s.c  o m*/
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

public class Main {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.java2s.com/style/download.png");
    BufferedImage bi = ImageIO.read(url);
    for (float q = 0.2f; q < .9f; q += .2f) {
      OutputStream outStream = new FileOutputStream(new File(
          "c:/Java_Dev/Image-" + q + ".jpg"));
      ImageWriter imgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
      ImageOutputStream ioStream = ImageIO.createImageOutputStream(outStream);
      imgWriter.setOutput(ioStream);

      JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(
          Locale.getDefault());
      jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      jpegParams.setCompressionQuality(q);

      imgWriter.write(null, new IIOImage(bi, null, null), jpegParams);

      ioStream.flush();
      ioStream.close();
      imgWriter.dispose();
    }
  }
}