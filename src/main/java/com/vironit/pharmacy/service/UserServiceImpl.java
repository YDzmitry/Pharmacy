package com.vironit.pharmacy.service;

import com.vironit.pharmacy.dao.userDao.UserDaoImpl;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.LoginValidatorException;
import com.vironit.pharmacy.model.user.User;
import com.vironit.pharmacy.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class UserServiceImpl implements MainService<User> {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    RegistrationValidator registrationValidator;

    @Transactional
    @Override
    public long save(User user) {
        registrationValidator.validate(user.getLogin(),user.getPassword());
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


    public User getByLoginAndPassword(RegistrationAndLoginUser loginUser) {
        Map<String, String> errMessageMap = new HashMap<>();
        User user;
        try{
            user = userDao.getByLoginAndPassword(loginUser);
        }catch (IndexOutOfBoundsException ex){
            errMessageMap.put("error","invalid credentials");
            throw new LoginValidatorException(errMessageMap);
        }
        return user;
    }

}