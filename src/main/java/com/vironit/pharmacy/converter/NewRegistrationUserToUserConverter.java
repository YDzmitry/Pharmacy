package com.vironit.pharmacy.converter;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.model.Role;
import com.vironit.pharmacy.model.TypeAccount;
import com.vironit.pharmacy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NewRegistrationUserToUserConverter implements Converter<RegistrationAndLoginUser,User> {


    @Autowired
    Map<String,Role> mapRoles;

    @Autowired
    Map<String,TypeAccount> mapTypeAccount;


    @Override
    public User convert(RegistrationAndLoginUser newRegistrationUser) {
        User user = new User();
        user.setLogin(newRegistrationUser.getLogin());
        user.setPassword(newRegistrationUser.getPassword());
        user.setRole(mapRoles.get("CUSTOMER"));
        user.setTypeAccount(mapTypeAccount.get("VERIFYING"));
        return user;
    }
}
