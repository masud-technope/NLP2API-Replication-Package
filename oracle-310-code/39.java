package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadataGetSchema {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();

            //
            // Gets DatabaseMetaData
            //
            DatabaseMetaData metadata = connection.getMetaData();

            //
            // Retrieves the schema names available in this database
            //
            ResultSet rs = metadata.getSchemas();

            while (rs.next()) {
                String schema = rs.getString("TABLE_SCHEM");
                System.out.println("Schema: " + schema);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get a connection to database.
     * @return a connection to database.
     * @throws Exception when an exception occurs.
     */
    private static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";        
        return DriverManager.getConnection(url, "kodejava", "welcome");
    }

    /**
     * Close a connection to database.
     * @param connection a connection to be closed.
     * @throws SQLException when an exception occurs.
     */
    private static void closeConnection(Connection connection)
            throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}