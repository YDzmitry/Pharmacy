package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
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

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(User user) {
        Long id = (Long) sessionFactory.getCurrentSession().save(user);
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        List<User> usersList = sessionFactory.getCurrentSession().createQuery("from User").list();
        return usersList;
    }

    @Override
    public User getByPK(Long key) {
        User user = sessionFactory.getCurrentSession().get(User.class, key);
        return user;
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
    }

    public User getByLoginAndPassword(RegistrationAndLoginUser loginUser) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User Where login = :login and password = :password";
        User user = (User) session.createQuery(hql)
                .setParameter("login", loginUser.getLogin())
                .setParameter("password", loginUser.getPassword())
                .list()
                .get(0);
        return user;
    }

}
