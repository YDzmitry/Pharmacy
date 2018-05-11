package com.vironit.pharmacy.service;

import java.util.List;

public interface MainService<T> {


    long save(T t);

    T getByPK(long id);


    List<T> list();


    void update(T t);


    void delete(long id);
}
