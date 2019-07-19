import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RotateTransformed extends JPanel {

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);

    for (double i = 0; i < 360; i += 5) {
      AffineTransform at = AffineTransform.getTranslateInstance(400 / 2, 400 / 2);
      at.rotate(Math.toRadians(i));
      g2.draw(at.createTransformedShape(e));
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new RotateTransformed());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
  }
}