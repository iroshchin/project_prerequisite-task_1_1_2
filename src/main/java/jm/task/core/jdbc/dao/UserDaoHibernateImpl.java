package jm.task.core.jdbc.dao;

import jakarta.transaction.*;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.getSessionFactory();

        session.createNativeQuery("CREATE TABLE IF NOT EXISTS users ("+
        "id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
        "name VARCHAR (100) NOT NULL, " +
        "lastName VARCHAR (200) NOT NULL, " +
        "age TINYINT NOT NULL)", void.class).executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction fx= session.beginTransaction();
        session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
        session.getTransaction().commit();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction fx= session.beginTransaction();
        session.persist(new User(name, lastName, age));

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction fx = session.beginTransaction();

        User user = session.get(User.class, id);
        if (user !=  null){
            session.remove(user);
        }

        fx.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class)//Select * from users
                .getResultList();
        session.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction fx = session.beginTransaction();
        try {
            session.remove("users");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        fx.commit();
        session.close();
    }

    @Override
    public void save(User user) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();
        session.persist(user);

        tx.commit();
        session.close();
    }

    @Override
    public void updateUser(long id, User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User existing = session.get(User.class, id);
        existing.setName(user.getName());
        existing.setLastName(user.getLastName());
        existing.setAge(user.getAge());

        tx.commit();
        session.close();
    }

}
