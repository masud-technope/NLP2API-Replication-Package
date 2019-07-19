package org.kodejava.example.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class FileMoveDemo {
    public static void main(String[] args) {
        //
        // Define the source and target of the file to be moved.
        //
        Path source = Paths.get("D:\Source\data.txt");
        Path target = Paths.get("D:\Backup\data.txt");

        try {
            //
            // Move file from source to target using the defined
            // configuration (REPLACE_EXISTING)
            //
            Files.move(source, target, REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}