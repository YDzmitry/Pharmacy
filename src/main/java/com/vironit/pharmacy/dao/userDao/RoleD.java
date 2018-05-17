package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dao.Dao;
import com.vironit.pharmacy.dao.EnumDao;
import com.vironit.pharmacy.model.user.Role;

import java.io.IOException;
import java.util.List;

public interface RoleD extends EnumDao<Role> {

    @Override
    List<Role> getAll() throws IOException;
}
