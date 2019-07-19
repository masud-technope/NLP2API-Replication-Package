import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;

public class FileDeflater {
  public static void main(String[] args) throws Exception {
    FileInputStream fin = new FileInputStream("a.dat");
    FileOutputStream fout = new FileOutputStream("b.dat");
    DeflaterOutputStream dos = new DeflaterOutputStream(fout);
    for (int c = fin.read(); c != -1; c = fin.read()) {
      dos.write(c);
    }
    dos.close();
    fin.close();
  }
}
