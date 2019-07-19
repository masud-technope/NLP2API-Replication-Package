import java.io.File;
import java.io.FileInputStream;

public class Main {
  public static void main(String[] args) throws Exception {
    boolean areFilesIdentical = true;
    File file1 = new File("c:\\file1.txt");
    File file2 = new File("c:\\file2.txt");
    FileInputStream fis1 = new FileInputStream(file1);
    FileInputStream fis2 = new FileInputStream(file2);
    int i1 = fis1.read();
    int i2 = fis2.read();
    while (i1 != -1) {
      if (i1 != i2) {
        areFilesIdentical = false;
        break;
      }
      i1 = fis1.read();
      i2 = fis2.read();
    }
    fis1.close();
    fis2.close();
    System.out.println(areFilesIdentical);
  }
}