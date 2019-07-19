package com.javadb.example;
 
import java.sql.*;
 
public class DBTest {
 
    Connection m_Connection = null;
    Statement m_Statement = null;
    ResultSet m_ResultSet = null;
    String m_Driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    String m_Url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyDatabase";
 
    public DBTest() {
        //Load driver
        try {
            Class.forName(m_Driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
 
    public void doWork() {
        String query = "";
        try {
            //Create connection object
            m_Connection = DriverManager.getConnection(m_Url, "userid", "password");
 
            //Create Statement object
            m_Statement = m_Connection.createStatement();
            query = "SELECT * FROM MyTable";
            //Execute the query
            m_ResultSet = m_Statement.executeQuery(query);
            //Loop through the results
            while (m_ResultSet.next()) {
                System.out.print(m_ResultSet.getString(1));
                System.out.print(", ");
                System.out.print(m_ResultSet.getString(2));
                System.out.print(", ");
                System.out.print(m_ResultSet.getString(3));
                System.out.print("\n"); //new line
 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(query);
        } finally {
            try {
                if (m_ResultSet != null) {
                    m_ResultSet.close();
                }
                if (m_Statement != null) {
                    m_Statement.close();
                }
                if (m_Connection != null) {
                    m_Connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        DBTest dbTest = new DBTest();
        dbTest.doWork();
    }
}