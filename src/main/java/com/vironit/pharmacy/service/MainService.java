package com.vironit.pharmacy.service;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.model.user.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MainService<T> {


    long save(T t);

    T getByPK(long id);


    List<T> list();


    void update(T t);


    void delete(long id);
}
