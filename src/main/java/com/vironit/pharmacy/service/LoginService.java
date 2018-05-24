package com.vironit.pharmacy.service;

import com.vironit.pharmacy.dao.userDao.UserDao;
import com.vironit.pharmacy.dto.RegistrationAndLoginUser;
import com.vironit.pharmacy.exception.LoginValidatorException;
import com.vironit.pharmacy.model.user.MainUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Transactional(readOnly = true)
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MainUser mainUser = userDao.getByLogin(login);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(mainUser.getRole()));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(mainUser.getLogin(),
                        mainUser.getPassword(),
                        roles);
        return userDetails;
    }
}