package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dao.EnumDao;
import com.vironit.pharmacy.model.user.TypeAccount;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.util.List;

public interface TypeAccountD extends EnumDao<TypeAccount> {
    @Override
    List<TypeAccount> getAll() throws IOException;
}
