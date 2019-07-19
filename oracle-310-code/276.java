import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] argv) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("infilename"),
        "8859_1"));
    String str = in.readLine();
    System.out.println(str);
  }
}
