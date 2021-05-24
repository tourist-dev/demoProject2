package com.example.demoProject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected static Connection intializeDatabse() throws ClassNotFoundException, SQLException {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "org.mariadb.jdbc.Driver";
        String dbURL = "jdbc:mariadb://localhost:3306/";
        String dbName = "orakris";
        String dbUserName = "root";
        String dbPassword = "";

        //Search for Driver class
        Class.forName(dbDriver);

        // establish connection
        Connection con = DriverManager.getConnection(dbURL + dbName , dbUserName, dbPassword);

        return con;
    }
}
