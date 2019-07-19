import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
//from w w w . ja  v  a2  s .  c om
public class Main {

  public static void main(String[] args) {
    FileSystem fileSystem = FileSystems.getDefault();
    FileSystemProvider provider = fileSystem.provider();

    System.out.println("Provider: " + provider.toString());
    System.out.println("Open: " + fileSystem.isOpen());
    System.out.println("Read Only: " + fileSystem.isReadOnly());

  }
}
