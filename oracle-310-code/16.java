package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionWithProperties {
    private String url = "jdbc:mysql://localhost/testdb";

    public static void main(String[] args) {
        GetConnectionWithProperties demo = new GetConnectionWithProperties();
        try {
            Connection connection = demo.getConnection();

            // do something with the connection.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "root");

        Connection connection = DriverManager.getConnection(url, connectionProps);
        System.out.println("Connected to database.");
        return connection;
    }
}