import java.io.InputStream;

public class Main {
  public static void main(String[] argv) throws Exception {
    String command = "ls";
    Process child = Runtime.getRuntime().exec(command);

    InputStream in = child.getInputStream();
    int c;
    while ((c = in.read()) != -1) {
      System.out.println((char) c);
    }
    in.close();
  }
}
