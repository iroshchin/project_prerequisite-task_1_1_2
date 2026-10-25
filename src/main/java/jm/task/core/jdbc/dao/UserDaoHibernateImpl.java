package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() throws SQLException {
    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR (100) NOT NULL," +
                "lastName VARCHAR (200) NOT NULL," +
                "age TINYINT NOT NULL)";

        try (
                Connection connection = Util.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);

        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        try (
                Connection connection = Util.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);

        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastName, age) VALUES ( ?, ?, ?)";

        try(
                Connection connection = Util.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try(
                Connection connection = Util.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String sql = "select id, name, lastname, age from users";

        try (
                Connection connection = Util.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("lastname"),
                        rs.getByte("age")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return users;
    }

        @Override
        public void cleanUsersTable () {
            String sql = "DELETE FROM users";

            try (
                    Connection connection = Util.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                stmt.executeUpdate();
            } catch (SQLException e) {
                handleSQLException(e);
            }
        }


        private void handleSQLException(SQLException e) {
        System.err.println("SQL State: " + e.getSQLState());
        System.err.println("Error Code: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());
    }
    }

