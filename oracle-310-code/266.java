import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.net.URL;
/*from w ww.  j a  va 2 s .co m*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {

    public static void draw(BufferedImage imageBG, BufferedImage imageFG) {
        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(20,20,30,30); 
        Ellipse2D.Double ellipse2 = new Ellipse2D.Double(25,25,30,30);
        Area circle = new Area(ellipse1);
        circle.subtract(new Area(ellipse2));

        Graphics2D g = imageBG.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setClip(circle);
        g.drawImage(imageFG, 0, 0, null);
        g.setClip(null);
        Stroke s = new BasicStroke(2);
        g.setStroke(s);
        g.setColor(Color.BLACK);
        g.draw(circle);
        g.dispose();

        JLabel l = new JLabel(new ImageIcon(imageBG));
        JOptionPane.showMessageDialog(null, l);
    }

    public static void main(String[] args) throws Exception {
        URL urlFG = new URL("http://www.java2s.com/style/download.png");
        URL urlBG = new URL("http://www.java2s.com/style/download.png");
        final BufferedImage biFG = ImageIO.read(urlFG);
        final BufferedImage biBG = ImageIO.read(urlBG);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                draw(biBG, biFG);
            }
        });
    }
}

