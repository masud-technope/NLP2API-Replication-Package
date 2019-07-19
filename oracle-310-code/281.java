
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainClass {

  public static void main(String[] args) {

    try {
      ZipFile zf = new ZipFile("your.zip");
      Enumeration e = zf.entries();
      while (e.hasMoreElements()) {
        ZipEntry ze = (ZipEntry) e.nextElement();
        String name = ze.getName();
        
        long crc = ze.getCrc();
        System.out.println("Its CRC is " + crc);
        
        String comment = ze.getComment();
        if (comment != null && !comment.equals("")) {
          System.out.println(comment);
        }
        if (ze.isDirectory()) {
          System.out.println(name + " is a directory");
        }
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}
