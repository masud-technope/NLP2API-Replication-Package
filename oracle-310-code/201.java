import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
/*from  ww w.  j ava2  s.  c  om*/
public class Main {
  public static void main(String[] args) {
     int[] pallet = makeGradientPallet();
     System.out.println(getColorFromPallet(pallet,0.5F));
  }
  private static int[] makeGradientPallet() {
    BufferedImage image = new BufferedImage(100, 1, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2  = image.createGraphics();
    Point2D start  = new Point2D.Float(0f, 0f);
    Point2D end    = new Point2D.Float(99f, 0f);
    float[] dist   = {0.0f, 0.5f, 1.0f};
    Color[] colors = { Color.RED, Color.YELLOW, Color.GREEN };
    g2.setPaint(new LinearGradientPaint(start, end, dist, colors));
    g2.fillRect(0, 0, 100, 1);
    g2.dispose();

    int width  = image.getWidth(null);
    int[] pallet = new int[width];
    PixelGrabber pg = new PixelGrabber(image, 0, 0, width, 1, pallet, 0, width);
    try {
      pg.grabPixels();
    } catch(Exception e) {
      e.printStackTrace();
    }
    return pallet;
  }
  private static Color getColorFromPallet(int[] pallet, float x) {
    if(x < 0.0 || x > 1.0) {
      throw new IllegalArgumentException("Parameter outside of expected range");
    }
    int i = (int)(pallet.length * x);
    int max = pallet.length-1;
    int index = i<0?0:i>max?max:i;
    int pix = pallet[index] & 0x00ffffff | (0x64 << 24);
    return new Color(pix, true);
  }
}
