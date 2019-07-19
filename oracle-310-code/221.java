package net.codejava.ftp;
 
import java.io.IOException;
 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPCmd;
 
/**
 * This program demonstrates how to send commands to a remote FTP server
 * using the Apache Commons Net API.
 * @author www.codejava.net
 *
 */
public class FTPSendCommandsExample {
 
    public static void main(String[] args) {
        String server = "www.yourserver.com";
        int port = 21;
        String user = "your_username";
        String pass = "your_password";
 
        FTPClient ftpClient = new FTPClient();
 
        try {
            ftpClient.connect(server, port);
 
            System.out.println(ftpClient.getReplyString());
 
            ftpClient.sendCommand(FTPCmd.USER, user);
 
            System.out.println(ftpClient.getReplyString());
 
            ftpClient.sendCommand(FTPCmd.PASS, pass);
 
            System.out.println(ftpClient.getReplyString());
 
            ftpClient.sendCommand(FTPCmd.CWD, "Upload");
 
            System.out.println(ftpClient.getReplyString());
 
            ftpClient.sendCommand(FTPCmd.MKD, "CodeJava");
 
            ftpClient.sendCommand(FTPCmd.QUIT, pass);
 
            System.out.println(ftpClient.getReplyString());
 
 
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
