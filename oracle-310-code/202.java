import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
//from w ww .  jav a2 s .  c  o m
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {
    List<Ellipse2D> shapes = new ArrayList<Ellipse2D>();
    int w = 400;
    int h = 100;
    BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Point2D mouse = new Point2D.Double(0, 0);
    JLabel l = new JLabel(new ImageIcon(img));

    Main() {
        shapes.add(new Ellipse2D.Double(10, 10,20, 30));
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                mouse = me.getPoint();
                drawImage();
            }
        };
        l.addMouseListener(listener);
        drawImage();

        JOptionPane.showMessageDialog(null, l);
    }

    public void drawImage() {
        Graphics2D g = img.createGraphics();
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(hints);

        g.setColor(Color.RED);
        int x = (int) mouse.getX();
        int y = (int) mouse.getY();
        g.setStroke(new BasicStroke(2));
        int s = 3;
        g.drawLine(x-s, y, x+s, y);
        g.drawLine(x, y-s, x, y+s);
        l.setIcon(new ImageIcon(img));

        g.dispose();
    }

    public static void main(String[] args) {
        new Main();
    }
}
