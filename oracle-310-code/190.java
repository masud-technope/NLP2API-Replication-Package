    /*from  www  .jav a 2  s  .  c om*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainClass {

  public static void main(String[] args) {

    if (args.length != 2) {
      System.err.println("Usage: java MainClass infile outfile");
    }
    try {
      copy(args[0], args[1]);
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }

  public static void copy(String inFile, String outFile) throws IOException {

    FileInputStream fin = null;
    FileOutputStream fout = null;

    try {
      fin = new FileInputStream(inFile);
      fout = new FileOutputStream(outFile);
      copy(fin, fout);
    } finally {
      try {
        if (fin != null)
          fin.close();
      } catch (IOException ex) {
      }
      try {
        if (fout != null)
          fout.close();
      } catch (IOException ex) {
      }
    }
  }

  public static void copy(InputStream in, OutputStream out) throws IOException {

    byte[] buffer = new byte[1024];
    while (true) {
      int bytesRead = in.read(buffer);
      if (bytesRead == -1)
        break;
      out.write(buffer, 0, bytesRead);
    }
  }
}
