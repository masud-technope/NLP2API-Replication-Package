import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
/*  w  w w . ja va  2s .co m*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.java2s.com/style/download.png");

        final BufferedImage originalImage = ImageIO.read(url);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        final BufferedImage textImage = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = textImage.createGraphics();

        FontRenderContext frc = g.getFontRenderContext();
        Font font = new Font("Arial", Font.BOLD, 50);
        GlyphVector gv = font.createGlyphVector(frc, "java2s.com");

        int xOff = 0;
        int yOff = 50;

        Shape shape = gv.getOutline(xOff,yOff);
        g.setClip(shape);
        g.drawImage(originalImage,0,0,null);

        g.setStroke(new BasicStroke(2f));
        g.setColor(Color.BLACK);
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.draw(shape);
        g.dispose();

        ImageIO.write(textImage,"png",new File("cat-text.png"));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null,new JLabel(new ImageIcon(textImage)));
            }
        });
    }
}
