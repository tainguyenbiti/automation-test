package com.acblogictics.databaseabclogictics.testcase.scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static Connection connection;

    public static void initializeConnection() throws SQLException, ClassNotFoundException  {
        if (connection == null || connection.isClosed()) {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Initialize the database connection
            connection = DriverManager.getConnection("jdbc:mysql://51.79.255.60:3306/abclogistic", "root", "logistic@123");
        }
    }

    public static void beginTransaction() throws SQLException , ClassNotFoundException {
        initializeConnection();

        // Begin transaction
        connection.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException , ClassNotFoundException {
        initializeConnection();

        // Commit the transaction
        connection.commit();
        connection.setAutoCommit(true);
    }

    public static void rollbackTransaction() throws SQLException , ClassNotFoundException {
        initializeConnection();

        // Rollback the transaction
        connection.rollback();
        connection.setAutoCommit(true);
    }
}

