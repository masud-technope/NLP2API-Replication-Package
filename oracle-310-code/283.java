import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;
import java.net.URL;
/* w w  w  .  j  a v a2s  . c om*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
   public static void main(String[] args)throws Exception {
      String mapUrlPath = "http://www.java2s.com/style/download.png";
         URL mapUrl = new URL(mapUrlPath);
         BufferedImage mapImage = ImageIO.read(mapUrl);
         Image newMapImage = Toolkit.getDefaultToolkit().createImage(
                           new FilteredImageSource(mapImage.getSource(),
                                    new GrayToColorFilter(Color.red)));
         ImageIcon mapIcon = new ImageIcon(mapImage);
         ImageIcon newMapIcon = new ImageIcon(newMapImage);

         JPanel imagePanel = new JPanel();
         imagePanel.add(new JLabel(mapIcon));
         imagePanel.add(new JLabel(newMapIcon));

         JOptionPane.showMessageDialog(null, imagePanel);
   }
}
class GrayToColorFilter extends RGBImageFilter {
  private Color c;

  public GrayToColorFilter(Color c) {
     this.c = c;
  }

  public int filterRGB(int x, int y, int argb) {
     return (argb | c.getRGB());
  }

}
