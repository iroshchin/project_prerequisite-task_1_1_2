package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // implement algorithm here
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();

        userDao.saveUser("John", "Berry", (byte) 45);
        userDao.saveUser("Milla", "Marks", (byte) 28);
        userDao.saveUser("Jane", "Doe", (byte) 10);
        userDao.saveUser("John", "Hills", (byte) 90);

        userDao.getAllUsers();

        userDao.cleanUsersTable();

        userDao.dropUsersTable();

    }
}
