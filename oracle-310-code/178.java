package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class QueryTimeOut {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();

            //
            // Sets the number of seconds the driver will wait for
            // a statement object to execute to the given number of
            // seconds. If the limit is exceeded, an SQLException
            // is thrown.
            //
            stmt.setQueryTimeout(60);

            //
            // Execute sql query
            //
            ResultSet rs = stmt.executeQuery("select * from products");

            while (rs.next()) {
                System.out.println("code: " + rs.getString("code")
                        + " ,product: " + rs.getString("name")
                        + " ,price: " + rs.getDouble("price")
                        + " ,qty: " + rs.getInt("qty"));
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
