package org.kodejava.example.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExample {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();
            //
            // Prepares a call to the sored procedure. This SP takes
            // one IN parameter
            //
            String query = "call GET_PRODUCT_BY_PRICE(?)";
            CallableStatement cb = connection.prepareCall(query);

            //
            // Sets the input parameter
            //
            cb.setDouble(1, 50d);

            //
            // Execute the query
            //
            ResultSet rs = cb.executeQuery();

            while (rs.next()) {
                System.out.println("Product: " + rs.getString(1));
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
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/kodejavadb";
        return DriverManager.getConnection(url, "root", "");
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