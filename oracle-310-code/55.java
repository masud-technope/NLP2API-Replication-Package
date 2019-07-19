package org.kodejava.example.sql;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;

public class DriverPropertyInfoDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/kodejavadb";

        try {
            //
            // Gets information about the possible properties for this
            // driver.
            //
            Driver driver = getDriver(url);
            DriverPropertyInfo[] properties = driver.getPropertyInfo(url, null);

            for (DriverPropertyInfo info : properties) {
                System.out.println("================================");
                System.out.println("Name       : " + info.name);
                System.out.println("Description: " + info.description);
                System.out.println("Value      : " + info.value);

                String[] choices = info.choices;
                if (choices != null) {
                    StringBuilder sb = new StringBuilder("Choices: ");
                    for (String choice : choices) {
                        sb.append(choice).append(",");
                    }

                    //
                    // Deletes the last ","
                    //
                    sb = sb.deleteCharAt(sb.length() - 1);
                    System.out.println(sb.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 
    // Get the Driver used to connect to database
    //
    private static Driver getDriver(String url) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getDriver(url);
    }
}