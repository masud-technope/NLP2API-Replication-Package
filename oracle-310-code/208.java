import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*from   ww w. j a  v  a  2  s  . c om*/
public class Main {
  public static Connection getConnection() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/databaseName";
    String username = "username";
    String password = "password";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static void main(String[] args) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = getConnection();
      String query = "insert into message values(?, ?, ?)";

      pstmt = conn.prepareStatement(query); // create a statement
      pstmt.setInt(1, 5); // set input parameter 1
      pstmt.setString(2, "head5"); // set input parameter 2
      pstmt.setString(3, "data5"); // set input parameter 3
      pstmt.executeUpdate(); // execute insert statement
      pstmt = conn.prepareStatement("insert into msgtag values(?, ?, ?)"); // create a statement
      pstmt.setInt(1, 55); // set input parameter 1
      pstmt.setString(2, "tag5"); // set input parameter 2
      pstmt.setInt(3, 5); // set input parameter 3
      pstmt.executeUpdate(); // execute insert statement
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      pstmt.close();
      conn.close();
    }
  }
}
