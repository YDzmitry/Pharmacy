package com.vironit.pharmacy.converter;

import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.model.user.CustomerUser;
import com.vironit.pharmacy.model.user.Role;
import com.vironit.pharmacy.model.user.TypeAccount;
import com.vironit.pharmacy.model.user.MainUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NewRegistrationUserToUserConverter implements Converter<RegistrationAndLoginUser, MainUser> {


    @Autowired
    Map<String, Role> mapRoles;

    @Autowired
    Map<String, TypeAccount> mapTypeAccount;


    @Override
    public MainUser convert(RegistrationAndLoginUser newRegistrationUser) {
        MainUser user = new CustomerUser();
        user.setLogin(newRegistrationUser.getLogin());
        user.setPassword(newRegistrationUser.getPassword());
        user.setRole(mapRoles.get("CUSTOMER"));
        user.setTypeAccount(mapTypeAccount.get("VERIFYING"));
        return user;
    }
}
