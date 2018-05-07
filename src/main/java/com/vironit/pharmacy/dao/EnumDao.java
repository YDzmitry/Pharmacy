package com.vironit.pharmacy.dao;

import java.io.IOException;
import java.util.List;

public interface EnumDao<T> {
    List<T> getAll() throws IOException;
}
