package org.kodejava.example.commons.net;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.io.IOException;

public class FileUploadDemo {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();

        String filename = "touch.dat";
        try (FileInputStream fis = new FileInputStream(filename)) {
            client.connect("ftp.example.org");
            client.login("admin", "admin123**");

            // Store file to server
            client.storeFile(filename, fis);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}