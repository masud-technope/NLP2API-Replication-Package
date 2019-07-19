package org.kodejava.example.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDeleteFile {
    public static void main(String[] args) {
        try {
            //
            // Create a config.cfg file under D:Temp directory.
            //
            Path path = Paths.get("D:\Temp\config.cfg");
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            //
            // Delete the path.cfg file specified by the Path.
            //
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}