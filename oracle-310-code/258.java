import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
  public static void main(String[] argv) {
    append(new File("c:\\a.txt"), "value");
  }

  public static void append(File aFile, String content) {
    try {
      PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream(aFile, true)));
      p.println(content);
      p.close();

    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(aFile);
    }
  }

}
