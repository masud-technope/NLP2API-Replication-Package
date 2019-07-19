import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.zip.Deflater;

public class Main {
  public static void main(String[] argv) throws Exception {
    byte[] input = "www.java2s.com".getBytes();

    Deflater compressor = new Deflater();
    compressor.setLevel(Deflater.BEST_COMPRESSION);

    compressor.setInput(input);
    compressor.finish();

    ByteArrayOutputStream bos = new ByteArrayOutputStream(input.length);

    byte[] buf = new byte[1024];
    while (!compressor.finished()) {
      int count = compressor.deflate(buf);
      bos.write(buf, 0, count);
    }
    bos.close();
    byte[] compressedData = bos.toByteArray();
    System.out.println(Arrays.toString(compressedData));
    
  }
}
