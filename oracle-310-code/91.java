import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
//w  w w  .j a v  a  2  s .  c  om
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BackgroundPane());
        frame.pack();
        frame.setVisible(true);
      }
    });
  }
}

class BackgroundPane extends JPanel {
  private BufferedImage bg;
  private int yOffset = 0;
  private int yDelta = 4;

  public BackgroundPane() {
    try {
      bg = ImageIO.read(new URL("http://www.java2s.com/style/download.png"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    Timer timer = new Timer(40, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        yOffset += yDelta;
        if (yOffset > getHeight()) {
          yOffset = 0;
        }
        repaint();
      }
    });
    timer.start();
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(bg.getWidth(),bg.getHeight());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    int xPos = (getWidth() - bg.getWidth()) / 2;
    int yPos = yOffset;

    yPos = yOffset;
    while (yPos < getHeight()) {
      g2d.drawImage(bg, xPos, yPos, this);
      yPos += bg.getHeight();
    }

    g2d.dispose();
  }
}


