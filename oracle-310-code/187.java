/*  w  w w . j  av a2 s  .  co m*/
/*
 * Copyright Aduna (http://www.aduna-software.com/) (c) 1997-2006.
 *
 * Licensed under the Aduna BSD-style license.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
  /**
   * Reads at most <tt>maxBytes</tt> bytes from the supplied input stream and
   * returns them as a byte array.
   *
   * @param in The InputStream supplying the bytes.
   * @param maxBytes The maximum number of bytes to read from the input
   * stream.
   * @return A byte array of size <tt>maxBytes</tt> if the input stream can
   * produce that amount of bytes, or a smaller byte containing all available
   * bytes from the stream otherwise.
   */
  public static final byte[] readBytes(InputStream in, int maxBytes)
    throws IOException
  {
    byte[] result = new byte[maxBytes];

    int bytesRead = in.read(result);
    int totalBytesRead = bytesRead;

    while (totalBytesRead < maxBytes && bytesRead >= 0) {
      // Read more bytes
      bytesRead = in.read(result, bytesRead, maxBytes - bytesRead);

      if (bytesRead > 0) {
        totalBytesRead += bytesRead;
      }
    }

    if (totalBytesRead < 0) {
      // InputStream at end-of-file
      result = new byte[0];
    }
    else if (totalBytesRead < maxBytes) {
      // Create smaller byte array
      byte[] tmp = new byte[totalBytesRead];
      System.arraycopy(result, 0, tmp, 0, totalBytesRead);
      result = tmp;
    }

    return result;
  }

}
