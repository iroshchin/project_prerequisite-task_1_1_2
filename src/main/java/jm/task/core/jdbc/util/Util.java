package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // set up a database connection
       private static final String URL = "jdbc:mysql://localhost:3306/sqltest";
       private static final String USER = "root";
       private static final String PASSWORD = "0000";

       public static Connection getConnection() {
           try {
               return DriverManager.getConnection(URL, USER, PASSWORD);
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
}