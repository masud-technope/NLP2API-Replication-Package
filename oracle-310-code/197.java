 /* w w  w .  j  a  va  2  s.  com*/


import java.io.File;
import java.io.RandomAccessFile;

public class Main {
  public static void append(String fileName, String text) throws Exception {
    File f = new File(fileName);
    long fileLength = f.length();
    RandomAccessFile raf = new RandomAccessFile(f, "rw");
    raf.seek(fileLength);
    raf.writeBytes(text);
    raf.close();
  }

  public static void append(String fileName, byte[] bytes) throws Exception {
    File f = new File(fileName);
    long fileLength = f.length();
    RandomAccessFile raf = new RandomAccessFile(f, "rw");
    raf.seek(fileLength);
    raf.write(bytes);
    raf.close();
  }
  public static void main(String[] args) throws Exception {
    append("c:\\tmp.txt", "Appended Data");
    append("c:\\tmp.bin", "Appended Data".getBytes());
  }
}
