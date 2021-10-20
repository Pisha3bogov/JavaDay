package ru.sapteh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1111";

    public static Connection getInstance() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connect false");
        }

        return connection;
    }

    public static void close(Connection connection) {
        try {
            if(!connection.isClosed()) connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
