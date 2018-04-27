package com.vironit.pharmacy.service;

import com.vironit.pharmacy.dao.UserDao;
import com.vironit.pharmacy.dao.UserDaoImpl;
import com.vironit.pharmacy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Transactional
    @Override
    public long save(User user) {
        return userDao.create(user);
    }

    @Override
    public User getByPK(long id) {
        return userDao.getByPK(id);
    }

    @Override
    public List<User> list() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

}