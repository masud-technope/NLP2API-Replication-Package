import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
//from  www .  java 2s.co  m
public class Main {
  public static void main(String[] args) throws Exception {
    String imageUrl = "http://www.java2s.com/style/download.png";
    String destinationFile = "c:/test.jpg";
    saveImage(imageUrl, destinationFile);
  }

  public static void saveImage(String imageUrl, String destinationFile)
      throws Exception {
    URL url = new URL(imageUrl);
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream(destinationFile);

    byte[] b = new byte[2048];
    int length;

    while ((length = is.read(b)) != -1) {
      os.write(b, 0, length);
    }

    is.close();
    os.close();
  }

}
