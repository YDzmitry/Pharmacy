package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;

import java.io.IOException;
import java.util.List;

public interface Dao<T> {
    Long create(T t) throws IOException;

    List<T> getAll() throws IOException;

    T getByPK(Long key) throws CustomGenericException;

    void update(T t);

    void delete(long id);
}
