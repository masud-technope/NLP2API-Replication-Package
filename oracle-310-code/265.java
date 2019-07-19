import java.awt.image.BufferedImage;
import java.net.URL;
/*from  w w w  . ja  v a2  s  . c o  m*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.java2s.com/style/download.png");
    final BufferedImage bi = ImageIO.read(url);
    final String size = bi.getWidth() + "x" + bi.getHeight();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JLabel l = new JLabel(size, new ImageIcon(bi), SwingConstants.RIGHT);
        JOptionPane.showMessageDialog(null, l);
      }
    });
  }
}
