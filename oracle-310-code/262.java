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
        Date lastModified = new Date(ze.getTime());
        long uncompressedSize = ze.getSize();
        long compressedSize = ze.getCompressedSize();
        
        System.out.println(name);
        System.out.println(lastModified);
        System.out.println(uncompressedSize);
        System.out.println(compressedSize);
        
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}
