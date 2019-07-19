import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Cloneable, Serializable {
  public Object clone() {
    Object clonedObj = null;
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(this);
      oos.close();

      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
      ObjectInputStream ois = new ObjectInputStream(bais);
      clonedObj = ois.readObject();
      ois.close();
    } catch (Exception cnfe) {
      System.out.println("Class not found " + cnfe);
    }
    return clonedObj;

  }
}