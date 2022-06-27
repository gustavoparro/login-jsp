package com.gustavoparro.ecommerce_jsp.connection;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DatabaseConnectionTest {

    @Test
    public void getConnection() {
        Connection connection = DatabaseConnection.getConnection();
    }

}
