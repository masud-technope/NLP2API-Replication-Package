import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://localhost:8080/postedresults.jsp");
    URLConnection conn = url.openConnection();
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.setUseCaches(false);
    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
    String content = "CONTENT=HELLO JSP !&ONEMORECONTENT =HELLO POST !";

    out.writeBytes(content);
    out.flush();
    out.close();

    DataInputStream in = new DataInputStream(conn.getInputStream());
    String str;
    while (null != ((str = in.readUTF()))) {
      System.out.println(str );
    }
    in.close();
  }
}