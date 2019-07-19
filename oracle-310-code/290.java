import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;
/*from  ww  w.  jav  a2s  . c  o  m*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

  public static BufferedImage getFlippedImage(BufferedImage bi) {
    BufferedImage flipped = new BufferedImage(bi.getWidth(), bi.getHeight(),
        bi.getType());
    AffineTransform tran = AffineTransform.getTranslateInstance(0,
        bi.getHeight());
    AffineTransform flip = AffineTransform.getScaleInstance(1d, -1d);
    tran.concatenate(flip);

    Graphics2D g = flipped.createGraphics();
    g.setTransform(tran);
    g.drawImage(bi, 0, 0, null);
    g.dispose();

    return flipped;
  }

  public static void main(String[] args) throws AWTException {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        try {
          URL  url = new URL("http://www.java2s.com/style/download.png");
          BufferedImage bi = ImageIO.read(url);
          JPanel gui = new JPanel(new GridLayout(1, 2, 2, 2));

          gui.add(new JLabel(new ImageIcon(bi)));
          gui.add(new JLabel(new ImageIcon(getFlippedImage(bi))));

          JOptionPane.showMessageDialog(null, gui);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    SwingUtilities.invokeLater(r);
  }
}
