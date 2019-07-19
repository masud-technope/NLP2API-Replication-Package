package org.kodejava.example.nio;

import java.io.IOException;
import java.nio.file.*;

public class FileCopyDemo {
    public static void main(String[] args) {
        //
        // Define the source and target of the file to be copied.
        //
        Path source = Paths.get("C:\resources\data.txt");
        Path target = Paths.get("C:\resources\data.bak");

        //
        // Define the options used in the file copy process.
        //
        CopyOption[] options = new CopyOption[] {
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };

        try {
            //
            // Copy file from source to target using the defined 
            // configuration.
            //
            Files.copy(source, target, options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}