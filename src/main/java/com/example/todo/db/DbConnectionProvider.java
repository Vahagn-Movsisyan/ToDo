package com.example.todo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {
    private static DbConnectionProvider dbConnectionProvider = null;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/todo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DbConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DbConnectionProvider getInstance() {
        if (dbConnectionProvider == null) {
            dbConnectionProvider = new DbConnectionProvider();
        }
        return dbConnectionProvider;
    }
}
