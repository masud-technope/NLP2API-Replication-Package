import java.io.IOException;
 
import org.apache.commons.net.ftp.FTPClient;
 
public class FTPDownloadDirectoryTest {
 
    public static void main(String[] args) {
        String server = "www.codejava.net";
        int port = 21;
        String user = "username";
        String pass = "password";
 
        FTPClient ftpClient = new FTPClient();
 
        try {
            // connect and login to the server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
 
            // use local passive mode to pass firewall
            ftpClient.enterLocalPassiveMode();
 
            System.out.println("Connected");
 
            String remoteDirPath = "/Test";
            String saveDirPath = "E:/Test/Download/FTP";
 
            FTPUtil.downloadDirectory(ftpClient, remoteDirPath, "", saveDirPath);
 
            // log out and disconnect from the server
            ftpClient.logout();
            ftpClient.disconnect();
 
            System.out.println("Disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
