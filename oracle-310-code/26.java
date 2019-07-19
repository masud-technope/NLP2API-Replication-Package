package org.kodejava.example.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class SettingFileTimeStamps {
    public static void main(String[] args) throws Exception {
        String path = "D:\resources\data.txt";
        Path file = Paths.get(path);

        BasicFileAttributes attr =
                Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println("lastModifiedTime() = " + attr.lastModifiedTime());

        //
        // Update the last modified time of the file.
        //
        long currentTimeMillis = System.currentTimeMillis();
        FileTime fileTime = FileTime.fromMillis(currentTimeMillis);
        Files.setLastModifiedTime(file, fileTime);

        attr = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println("lastModifiedTime() = " + attr.lastModifiedTime());
    }
}