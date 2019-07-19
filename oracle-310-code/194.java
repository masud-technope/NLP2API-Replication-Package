// w  ww  .ja va2  s  .  c  om
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws Exception {
    Path firstPath = Paths.get("/home/music/users.txt");
    Path secondPath = Paths.get("/docs/status.txt");

    System.out.println("exists: " + Files.exists(firstPath));
    System.out.println("notExists: " + Files.notExists(firstPath));
    
  }
}
