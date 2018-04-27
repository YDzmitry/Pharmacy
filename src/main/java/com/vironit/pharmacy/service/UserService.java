package com.vironit.pharmacy.service;

import com.vironit.pharmacy.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    long save(User user);

    User getByPK(long id);

    List<User> list();

    @Transactional
    void update(User user);

    @Transactional
    void delete(long id);
}
