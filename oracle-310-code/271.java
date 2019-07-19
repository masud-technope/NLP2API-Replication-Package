package net.codejava.jdbc;
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 * This program demonstrates how to read file data from database and save the
 * data into a file on disk.
 * @author www.codejava.net
 *
 */
public class JdbcReadFile {
    private static final int BUFFER_SIZE = 4096;
 
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/contactdb";
        String user = "root";
        String password = "secret";
 
        String filePath = "D:/Photos/Tom.jpg";
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "SELECT photo FROM person WHERE first_name=? AND last_name=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "Tom");
            statement.setString(2, "Eagar");
 
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("photo");
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);
 
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
