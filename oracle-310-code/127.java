import java.net.InetAddress;
import java.net.Socket;

public class WebPing {
  public static void main(String[] args) {
    try {
      InetAddress addr;
      Socket sock = new Socket("www.java2s.com", 80);
      addr = sock.getInetAddress();
      System.out.println("Connected to " + addr);
      sock.close();
    } catch (java.io.IOException e) {
      System.out.println("Can't connect to " + args[0]);
      System.out.println(e);
    }
  }
}