package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.User;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface UserDao extends Dao<User> {

    @Override
    Long create(User user) throws CustomGenericException;

    @Override
    List<User> getAll() throws CustomGenericException;

    @Override
    User getByPK(Long key) throws CustomGenericException;

    @Override
    void update(User user);

    @Override
    void delete(long id);

    long getByLoginAndPassword(RegistrationAndLoginUser loginUser);
}
