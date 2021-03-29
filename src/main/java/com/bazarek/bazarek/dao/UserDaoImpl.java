package com.bazarek.bazarek.dao;

import com.bazarek.bazarek.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User ",User.class).getResultList();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
