package org.kodejava.examples.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReadLastCharacters {
    public static void main(String[] args) {
        //
        // Defines the path to the log file and creates a ByteBuffer.
        //
        Path logPath = 
                Paths.get("D:\Appservers\apache-tomcat-7.0.37\logs\catalina.out");
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        try {
            //
            // Creates FileChannel and open the file channel for read access.
            //
            FileChannel channel = FileChannel.open(logPath, StandardOpenOption.READ);

            //
            // Read a sequence of bytes from the channel into the buffer starting
            // at given file position, which is the channel size - 1000. Because
            // we are going to read the last 1000 characters from the file.
            //
            channel.read(buffer, channel.size() - 1000);
            System.out.println("Characters = " + new String(buffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}