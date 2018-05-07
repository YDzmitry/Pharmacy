package com.vironit.pharmacy.converter;

import com.vironit.pharmacy.dto.NewRegistrationUser;
import com.vironit.pharmacy.model.Role;
import com.vironit.pharmacy.model.TypeAccount;
import com.vironit.pharmacy.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NewRegistrationUserToUserConverter implements Converter<NewRegistrationUser,User> {

    @Override
    public User convert(NewRegistrationUser newRegistrationUser) {
        User user = new User();
        user.setLogin(newRegistrationUser.getLogin());
        user.setPassword(newRegistrationUser.getPassword());
        user.setRole(new Role("CUSTOMER"));
        user.setTypeAccount(new TypeAccount("VERIFYING"));
        return user;
    }
}
