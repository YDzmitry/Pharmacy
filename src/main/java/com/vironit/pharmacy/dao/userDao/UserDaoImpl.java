package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.model.user.MainUser;
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
    public Long create(MainUser user) {
        Long id = (Long) sessionFactory.getCurrentSession().save(user);
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MainUser> getAll() {
        List<MainUser> usersList = sessionFactory.getCurrentSession().createQuery("from User").list();
        return usersList;
    }

    @Override
    public MainUser getByPK(Long key) {
        MainUser user = sessionFactory.getCurrentSession().get(MainUser.class, key);
        return user;
    }

    @Override
    public void update(MainUser user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(MainUser.class, id));
    }

    public MainUser getByLogin(String loginUser) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User Where login = :login";
        MainUser user = (MainUser) session.createQuery(hql)
                .setParameter("login", loginUser)
                .list()
                .get(0);
        return user;
    }

}
