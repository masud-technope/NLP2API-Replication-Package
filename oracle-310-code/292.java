import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
//from  ww  w .j a v a  2  s  .c  o  m
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
  public static void main(String[] args) throws IOException {
    URL url = new URL("http://www.java2s.com/style/download.png");
    BufferedImage im = ImageIO.read(url);
    URL url2 = new URL("http://www.java2s.com/style/download.png");
    BufferedImage im2 = ImageIO.read(url2);
    Graphics2D g = im.createGraphics();
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
    g.drawImage(im2, (im.getWidth() - im2.getWidth()) / 2,
        (im.getHeight() - im2.getHeight()) / 2, null);
    g.dispose();

    display(im);
    ImageIO.write(im, "jpeg", new File("output.jpeg"));
  }

  public static void display(BufferedImage image) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JLabel(new ImageIcon(image)));
    f.pack();
    f.setVisible(true);
  }
}
