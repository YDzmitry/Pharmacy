package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;

import java.io.IOException;
import java.util.List;

public interface Dao<T> {
    Long create(T t);

    List<T> getAll();

    T getByPK(Long key);

    void update(T t);

    void delete(long id);


}
