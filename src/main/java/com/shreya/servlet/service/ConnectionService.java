package com.shreya.servlet.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

//    public Connection getConnection() {
//        Connection connection = null;
//        try {
//            String url = "jdbc:mysql://localhost:3306/foodorder";
//            String username = "root";
//            String password = "root";
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Connected to the database!");
//        } catch (SQLException e) {
//
//            System.err.println("Connection error: " + e.getMessage());
//        }
//        return connection;
//    }
//}
//
//


        private static final String URL = "jdbc:mysql://localhost:3306/foodorder"; // ✅ Change this
        private static final String USER = "root"; //
        private static final String PASSWORD = "root";

        public Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Load MySQL JDBC Driver
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("MySQL JDBC Driver not found", e);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to connect to database", e);
            }
        }
    }
