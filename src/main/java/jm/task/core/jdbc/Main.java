package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        UserDao userDao = new UserDaoJDBCImpl();
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
