package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

public class Main {
    public static void main(String[] args){

//        UserDao userDao = new UserDaoJDBCImpl();
//        userDao.createUsersTable();
//
//        userDao.saveUser("John", "Berry", (byte) 45);
//        userDao.saveUser("Milla", "Marks", (byte) 28);
//        userDao.saveUser("Jane", "Doe", (byte) 10);
//        userDao.saveUser("John", "Hills", (byte) 90);
//
//        userDao.getAllUsers();

//        userDao.cleanUsersTable();
//
//        userDao.dropUsersTable();


//        User user = new User("Jane", "Fawn", (byte) 99);
        UserDaoHibernateImpl daoHibernate = new UserDaoHibernateImpl();

//        daoHibernate.updateUser(2, user);
//        daoHibernate.save(user);
//        daoHibernate.saveUser("Joe", "Black", (byte)45);
//        daoHibernate.getAllUsers();
//        daoHibernate.cleanUsersTable();
//        daoHibernate.removeUserById(3);
//        daoHibernate.createUsersTable();
//        daoHibernate.dropUsersTable();
    }
}
