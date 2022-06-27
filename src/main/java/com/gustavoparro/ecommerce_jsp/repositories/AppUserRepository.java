package com.gustavoparro.ecommerce_jsp.repositories;

import com.gustavoparro.ecommerce_jsp.connection.DatabaseConnection;
import com.gustavoparro.ecommerce_jsp.models.AppUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AppUserRepository {

    protected Connection connection;

    public AppUserRepository() {
        connection = DatabaseConnection.getConnection();
    }

    public Optional<AppUser> authenticateUser(AppUser user) {
        PreparedStatement preparedStatement;
        String sql = """
                SELECT * FROM public.app_user
                WHERE email like ? AND password like ?
                ORDER BY id ASC
                """;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            return buildAppUser(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<AppUser> buildAppUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            AppUser appUser = new AppUser(resultSet.getLong("id"), resultSet.getString("name"),
                    resultSet.getString("email"), resultSet.getString("password"));

            return Optional.of(appUser);
        }

        return Optional.empty();
    }

}
