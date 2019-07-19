/* w w  w.java2 s.c o m*/
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame();
        frame.add(new TestImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
      }
    });
  }
}

class TestImage extends JPanel {
  private static final int SCREEN_WIDTH = 256;
  BufferedImage img;

  public TestImage() {
    try {
      img = ImageIO.read(getClass().getResource("resources/yourimage.png"));
    } catch (IOException ex) {
      System.err.println("Could not load image");
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 0, 0, this);
  }

  public Dimension getPreferredSize() {
    return new Dimension(SCREEN_WIDTH, SCREEN_WIDTH);

  }

}
