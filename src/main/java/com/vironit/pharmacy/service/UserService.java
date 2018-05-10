package com.vironit.pharmacy.service;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.model.user.User;
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

    User getByLoginAndPassword(RegistrationAndLoginUser user);
}
