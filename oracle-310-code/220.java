package net.codejava.ftp;
 
import java.io.IOException;
 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
 
/**
 * This program demonstrates how to get size of a particular file on a
 * FTP server, using Apache Commons Net API.
 * @author www.codejava.net
 *
 */
public class FTPFileSize {
 
    public static void main(String[] args) {
        String server = "www.yourserver.com";
        int port = 21;
        String user = "your_username";
        String pass = "your_password";
 
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
 
            String filePath = "/photos/mywedding.jpg";
 
            FTPFile file = ftpClient.mlistFile(filePath);
            long size = file.getSize();
            System.out.println("File size = " + size);
 
            ftpClient.sendCommand("SIZE", filePath);
            String reply = ftpClient.getReplyString();
            System.out.println("Reply for size command: " + reply);
 
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
