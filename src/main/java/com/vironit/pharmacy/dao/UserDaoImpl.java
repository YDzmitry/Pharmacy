package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.config.ConnectionConfig;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(User user) throws CustomGenericException {
        Long id = (Long) sessionFactory.getCurrentSession().save(user);
        logger.info("Person saved successfully, Person Details=" + user);
        return id;
    }

    @Override
    public List<User> getAll() throws CustomGenericException {
        List<User> usersList = sessionFactory.getCurrentSession().createQuery("from User").list();
        for (User user : usersList) {
            logger.info("Person List::" + user);
        }
        return usersList;
    }

    @Override
    public User getByPK(Long key) throws CustomGenericException {
        logger.info("Person loaded successfully, Person details=" + key);
        return sessionFactory.getCurrentSession().get(User.class, key);
    }

    @Override
    public void update(User user) {
        logger.info("Person updated successfully, Person Details=" + user);
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
        logger.info("Person deleted successfully");
    }

    @Override
    public long getByLoginAndPassword(RegistrationAndLoginUser loginUser) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User Where User.login = :login and User.password = :password";
        User user = (User) session.createQuery(hql)
                .setParameter("login",loginUser.getLogin())
                .setParameter("password",loginUser.getPassword())
                .list().get(0);
        return user.getId();
    }

}
