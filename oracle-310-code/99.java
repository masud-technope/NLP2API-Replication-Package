import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class Main {
  public static void main(String[] args) {
    AffineTransform tx = new AffineTransform();
    tx.rotate(0.5);
    Rectangle shape = new Rectangle(1, 1, 1, 1);
    Shape newShape = tx.createTransformedShape(shape);
    
    System.out.println("done");
  }
}