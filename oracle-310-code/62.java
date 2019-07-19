import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    FTPClient client = new FTPClient();

    client.connect("ftp.domain.com");
    client.login("admin", "secret");
    String filename = "/testing/data.txt";
    boolean deleted = client.deleteFile(filename);
    if (deleted) {
      System.out.println("File deleted...");
    }

    client.logout();
    client.disconnect();
  }
}
 