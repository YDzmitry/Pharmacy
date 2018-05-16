package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dao.Dao;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.user.MainUser;

import java.util.List;

public interface UserDao extends Dao<MainUser> {

    @Override
    Long create(MainUser user) throws CustomGenericException;

    @Override
    List<MainUser> getAll() throws CustomGenericException;

    @Override
    MainUser getByPK(Long key) throws CustomGenericException;

    @Override
    void update(MainUser user);

    @Override
    void delete(long id);

    MainUser getByLoginAndPassword(RegistrationAndLoginUser loginUser);
}
