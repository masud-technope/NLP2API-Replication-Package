import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Zip archive operations are handled by this class.
 * 
 * @author fdietz
 */
public class ZipFileIO {

  /**
   * No instances needed.
   */
  private ZipFileIO() {
    // don't instantiate this class
  }

  /**
   * Extract zip file to destination folder.
   * 
   * @param file
   *            zip file to extract
   * @param destination
   *            destinatin folder
   */
  public static void extract(File file, File destination) throws IOException {
    ZipInputStream in = null;
    OutputStream out = null;
    try {
      // Open the ZIP file
      in = new ZipInputStream(new FileInputStream(file));

      // Get the first entry
      ZipEntry entry = null;

      while ((entry = in.getNextEntry()) != null) {
        String outFilename = entry.getName();

        // Open the output file
        if (entry.isDirectory()) {
          new File(destination, outFilename).mkdirs();
        } else {
          out = new FileOutputStream(new File(destination,
              outFilename));

          // Transfer bytes from the ZIP file to the output file
          byte[] buf = new byte[1024];
          int len;

          while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
          }

          // Close the stream
          out.close();
        }
      }
    } finally {
      // Close the stream
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }

  /**
   * Return the first directory of this archive. This is needed to determine
   * the plugin directory.
   * 
   * @param zipFile
   * @return <class>File</class> containing the first entry of this archive
   */
  public static File getFirstFile(File zipFile) throws IOException {
    ZipInputStream in = null;
    try {
      // Open the ZIP file
      in = new ZipInputStream(new FileInputStream(zipFile));

      // Get the first entry
      ZipEntry entry = null;

      while ((entry = in.getNextEntry()) != null) {
        String outFilename = entry.getName();

        if (entry.isDirectory()) {
          return new File(outFilename);
        }
      }
    } finally {
      if (in != null) {
        // Close the stream
        in.close();
      }
    }
    return null;
  }
}
