package com.vironit.pharmacy.dao.userDao;

import java.io.IOException;
import java.util.List;

public interface EnumDao<T> {
    List<T> getAll() throws IOException;
}
