package com.vironit.pharmacy.config;

import com.vironit.pharmacy.dao.OrderTypeDao;
import com.vironit.pharmacy.dao.userDao.RoleDao;
import com.vironit.pharmacy.dao.userDao.TypeAccountDao;
import com.vironit.pharmacy.model.order.OrderType;
import com.vironit.pharmacy.model.user.Role;
import com.vironit.pharmacy.model.user.TypeAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Transactional
public class EnumTableConfiguration {

    @Autowired
    RoleDao roleDao;

    @Autowired
    TypeAccountDao typeAccountDao;

    @Autowired
    OrderTypeDao orderTypeDao;


    @Bean
    @SuppressWarnings("unchecked")
    public Map<String, Role> getRoles() throws IOException {
        List<Role> list = roleDao.getAll();
        Map<String, Role> map = new HashMap<>();
        for (Role role : list) {
            map.put(role.getRole(), role);
        }
        return map;
    }


    @Bean
    @SuppressWarnings("unchecked")
    public Map<String, TypeAccount> getTypesAccount() throws IOException {
        List<TypeAccount> list = typeAccountDao.getAll();
        Map<String, TypeAccount> map = new HashMap<>();
        for (TypeAccount typeAccount : list) {
            map.put(typeAccount.getType(), typeAccount);
        }
        return map;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public Map<String, OrderType> getOrderTypes() throws IOException {
        List<OrderType> list = orderTypeDao.getAll();
        Map<String, OrderType> map = new HashMap<>();
        for (OrderType orderType : list) {
            map.put(orderType.getType(), orderType);
        }
        return map;
    }
}
