/*www  .  j ava 2  s. com*/
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class Main {
  public static void main(String[] args) throws Exception {
    FileOutputStream fos = new FileOutputStream("file.txt");
    FileLock fl = fos.getChannel().tryLock();
    if (fl != null) {
      System.out.println("Locked File");
      Thread.sleep(100);
      fl.release();
      System.out.println("Released Lock");
    }
    fos.close();
  }
}
