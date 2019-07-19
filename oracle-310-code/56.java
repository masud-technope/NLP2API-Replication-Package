package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class NumericFunction {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/kodejava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            DatabaseMetaData metadata = connection.getMetaData();

            //
            // Get numeric functions supported by database
            //
            String[] functions = metadata.getNumericFunctions().split(",\s*");

            for (int i = 0; i < functions.length; i++) {
                String function = functions[i];
                System.out.println("Function = " + function);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}