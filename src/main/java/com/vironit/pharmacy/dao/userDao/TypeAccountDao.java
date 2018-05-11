package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.model.user.TypeAccount;

import java.io.IOException;
import java.util.List;

public interface TypeAccountDao extends EnumDao<TypeAccount> {
    @Override
    List<TypeAccount> getAll() throws IOException;
}
