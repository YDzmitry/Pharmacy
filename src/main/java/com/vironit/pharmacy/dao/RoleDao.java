package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.model.Role;

import java.io.IOException;
import java.util.List;

public interface RoleDao extends EnumDao<Role>{

    List<Role> getAll() throws IOException;
}
