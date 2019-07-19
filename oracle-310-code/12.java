package org.kodejava.example.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MD5FileHashDemo {
    public static void main(String[] args) {
        try {
            // Define the data file path and create an InputStream object.
            String data = System.getProperty("user.dir") + "/target/classes/data.txt" ;
            File file = new File(data);
            InputStream is = new FileInputStream(file);

            // Calculates the MD5 digest of the given InputStream object.
            // It will generate a 32 characters hex string.
            String digest = DigestUtils.md5Hex(is);
            System.out.println("Digest = " + digest);
            System.out.println("Length = " + digest.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}