import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainClass {
  public static void main(String[] args) {
    try {
      char[] chars = new char[2];
      chars[0] = '\u4F60';
      chars[1] = '\u597D';
      String encoding = "GB18030";
      File textFile = new File("C:\\temp\\myFile.txt");
      PrintWriter writer = new PrintWriter(textFile,

      encoding);
      writer.write(chars);
      writer.close();

      // read back
      InputStreamReader reader = new InputStreamReader(new FileInputStream(textFile), encoding);
      char[] chars2 = new char[2];
      reader.read(chars2);
      System.out.print(chars2[0]);
      System.out.print(chars2[1]);
      reader.close();
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }
}
