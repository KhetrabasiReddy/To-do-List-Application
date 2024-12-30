package com.khetrabasi;

import java.sql.*;

public class ToDoListManager {
    private final String url = "jdbc:mysql://localhost:3306/fullstackdb";// ReplaceWithYourOwnDatabaseName
    private final String user = "khetrabasi"; // ReplaceYourMysqlUsername
    private final String password = "password"; // ReplaceYourMysqlPassword

    // Establishing a connection to the database
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
//delete this comment
    public void addTask(String description) {
        String query = "INSERT INTO tasks (description) VALUES (?)";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, description);
            statement.executeUpdate();
            System.out.println("Task added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void viewTasks() {
        String query = "SELECT * FROM tasks";
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No tasks to display.");
            } else {
                while (resultSet.next()) {
                    System.out.println("Task ID: " + resultSet.getInt("id") +
                            ", Description: " + resultSet.getString("description"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching tasks: " + e.getMessage());
        }
    }

    public void editTask(int id, String newDescription) {
        String query = "UPDATE tasks SET description = ? WHERE id = ?";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newDescription);
            statement.setInt(2, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task updated successfully!");
            } else {
                System.out.println("Task not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    public void deleteTask(int id) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task removed successfully!");
            } else {
                System.out.println("Task not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }
}
