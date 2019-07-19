import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
/*from www .  j a  v a  2 s. c o m*/
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.add(new TestPane());
    frame.pack();
    frame.setVisible(true);
  }
}

class TestPane extends JPanel {
  String text;

  public TestPane() {
    text = "this is a test";
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(200, 200);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setColor(Color.RED);
    g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
    g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

    Font font = new Font("Arial", Font.BOLD, 48);
    g2d.setFont(font);
    FontMetrics fm = g2d.getFontMetrics();
    int x = ((getWidth() - fm.stringWidth(text)) / 2);
    int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

    g2d.setColor(Color.BLACK);
    g2d.drawString(text, x, y);

    g2d.dispose();
  }
}
