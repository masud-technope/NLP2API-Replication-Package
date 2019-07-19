import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// w  w w . jav a 2 s .co m
public class Main {

  public static void main(String[] args) throws Exception {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection conn = DriverManager
        .getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};"
            + "Dbq=C://Book1.xlsx;");

    PreparedStatement s = conn
        .prepareStatement("SELECT * FROM [Sheet1$] WHERE [MetricMonth] = ?");
    s.setString(1, "Jul-2013");
    s.execute();
    ResultSet rs = s.getResultSet();
    if (rs != null) {
      while (rs.next()) {
        System.out.println(rs.getInt("All"));
      }
    }
    s.close();

    conn.close();
  }

}
