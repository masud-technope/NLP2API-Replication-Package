package org.kodejava.example.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementDemo {
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "kodejava";
    private static String password = "welcome";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);

            //
            // Create a CallableStatement to execute the CREATE_USERS procedure
            // 
            CallableStatement stmt = conn.prepareCall("{call CREATE_USERS (?, ?, ?, ?, ?, ?)}");

            //
            // Defines all the required parameter values.
            // 
            stmt.setString(1, "kodejava");
            stmt.setString(2, "welcome");
            stmt.setString(3, "Kode");
            stmt.setString(4, "Java");
            stmt.setString(5, "Denpasar - Bali");
            stmt.setString(6, "webmaster[at]kodejava[.]org");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }
}