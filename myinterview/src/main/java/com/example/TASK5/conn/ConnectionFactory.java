package com.example.TASK5.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/usuario_db?createDatabaseIfNotExist=true";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
}
