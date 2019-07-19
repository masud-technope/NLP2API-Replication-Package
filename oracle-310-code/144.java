import java.io.FilePermission;
import java.security.AccessController;

public class Main {
  public static void main(String[] argv) throws Exception {
    AccessController.checkPermission(new FilePermission("/tmp/*", "read,write"));

  }
}