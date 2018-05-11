package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.model.user.Role;

import java.io.IOException;
import java.util.List;

public interface RoleDao extends EnumDao<Role> {

    List<Role> getAll() throws IOException;
}
