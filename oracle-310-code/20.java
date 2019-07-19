package org.kodejava.example.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTree {
    public static void main(String[] args) {
        try {
            Path startDir = Paths.get("D:\");
            Files.walkFileTree(startDir, new FindTextFilesVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FindTextFilesVisitor.
     */
    static class FindTextFilesVisitor extends SimpleFileVisitor {
        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attrs)
                throws IOException {
            if (file.toString().endsWith(".txt")) {
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}