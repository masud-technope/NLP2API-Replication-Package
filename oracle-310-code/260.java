import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainClass {
  public static void main(String[] a) {

    FileReader fr;
    try {
      fr = new FileReader (new File("yourFile.txt"));
      BufferedReader br = new BufferedReader (fr);
      String line = br.readLine();
      while (line != null) {
          System.out.println(line);
          line = br.readLine();
      }
      br.close();
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
