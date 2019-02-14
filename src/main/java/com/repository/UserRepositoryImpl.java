package com.repository;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean addUser(User user) {
        long id = getUserIdByUsername(user.getUsername());
        if (id != -1L) return false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        long newId = (long)session.save(user);
        transaction.commit();
        session.close();
        User checkUser = getUserById(newId);
        return checkUser != null;
    }

    private long getUserIdByUsername(String username) {
        Query<Long> query = sessionFactory.openSession().createQuery("select id from User as u where u.username = :username");
        query.setParameter("username", username);
        return query.uniqueResultOptional().orElse(-1L);
    }

    public User getUserByUsername(String username) {
        Query<User> query = sessionFactory.openSession().createQuery("from User as u where u.username = :username");
        query.setParameter("username", username);
        return query.uniqueResultOptional().orElse(null);
    }

    @Override
    public boolean updateUserProfile(User user) {
        if (user == null) return false;
        long checkedId = getUserIdByUsername(user.getUsername());
        if (checkedId != user.getId() && checkedId != -1) return false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        User updatedUser = getUserById(user.getId());
        return user.equals(updatedUser);
    }

    @Override
    public User getUserById(long id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public boolean removeUser(long id) {
        User user = getUserById(id);
        if (user != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            session.close();
            long removedId = getUserIdByUsername(user.getUsername());
            return removedId == -1;
        }
        return false;
    }

    @Override
    public Set<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> list = (List<User>)session.createQuery("From User").list();
        return list == null ? new LinkedHashSet<>() : new LinkedHashSet<>(list);
    }
}
