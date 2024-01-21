package com.example.todo.manager;

import com.example.todo.db.DbConnectionProvider;
import com.example.todo.model.User;

import java.sql.*;

public class UserManager {
    private final Connection connection = DbConnectionProvider.getInstance().getConnection();

    public void addUser(User user) {
        String sql = "INSERT INTO user(username, email, password) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        String query = "SELECT * FROM user WHERE id =" + id;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("username"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
