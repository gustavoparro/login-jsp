package com.gustavoparro.ecommerce_jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.gustavoparro.ecommerce_jsp.connection.ConnectionAttributes.*;

public class DatabaseConnection {

    private static Connection connection;

    static {
        connect();
    }

    private DatabaseConnection() { }

    private static void connect() {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");

                connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
                connection.setAutoCommit(false);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
