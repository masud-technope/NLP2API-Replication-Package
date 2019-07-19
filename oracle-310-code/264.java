import java.awt.Image;
import java.io.IOException;
//from   w w w. j  ava  2 s.co m
import javax.swing.ImageIcon;

public class Main {

  static boolean isImage(String image_path) {
    Image image = new ImageIcon(image_path).getImage();
    if (image.getWidth(null) == -1) {
      return false;
    } else {
      return true;
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println(isImage("/Users/image.jpg"));
  }
}
