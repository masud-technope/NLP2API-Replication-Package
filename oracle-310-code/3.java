package org.kodejava.example.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GZipDecompressExample {
    public static void main(String[] args) {
        //
        // GZip input and output file.
        //
        String sourceFile = "core-sample/target/classes/output.gz";
        String targetFile = "core-sample/target/classes/input-1.txt";

        try {
            //
            // Create a file input stream to read the source file.
            //
            FileInputStream fis = new FileInputStream(sourceFile);

            //
            // Create a gzip input stream to decompress the source
            // file defined by the file input stream.
            //
            GZIPInputStream gzis = new GZIPInputStream(fis);

            //
            // Create a buffer and temporary variable used during the
            // file decompress process.
            //
            byte[] buffer = new byte[1024];
            int length;

            //
            // Create file output stream where the decompress result
            // will be stored.
            //
            FileOutputStream fos = new FileOutputStream(targetFile);

            //
            // Read from the compressed source file and write the
            // decompress file.
            //
            while ((length = gzis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            //
            // Close the resources.
            //
            fos.close();
            gzis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}