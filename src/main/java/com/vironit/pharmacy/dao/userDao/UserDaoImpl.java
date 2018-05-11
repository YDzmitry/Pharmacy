package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.user.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(User user) {
        Long id = (Long) sessionFactory.getCurrentSession().save(user);
        logger.info("Person saved successfully, Person Details=" + user);
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        List<User> usersList = sessionFactory.getCurrentSession().createQuery("from User").list();
        for (User user : usersList) {
            logger.info("Person List::" + user);
        }
        return usersList;
    }

    @Override
    public User getByPK(Long key) {
        User user =  sessionFactory.getCurrentSession().get(User.class, key);
        logger.info("Person loaded successfully, Person details=" + key);
        return user;
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
        logger.info("Person updated successfully, Person Details=" + user);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
        logger.info("Person deleted successfully");
    }

    public User getByLoginAndPassword(RegistrationAndLoginUser loginUser) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User Where login = :login and password = :password";
        User user = (User) session.createQuery(hql)
                .setParameter("login",loginUser.getLogin())
                .setParameter("password",loginUser.getPassword())
                .list()
                .get(0);
        return user;
    }

}
