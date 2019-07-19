package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateMySQLDatabaseExample {
    public static void main(String[] args) {
        // Defines the JDBC URL. As you can see, we are not specifying
        // the database name in the URL.
        String url = "jdbc:mysql://localhost";

        // Defines username and password to connect to database server.
        String username = "root";
        String password = "root";

        // SQL command to create a database in MySQL.
        String sql = "CREATE DATABASE IF NOT EXISTS DEMODB";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}