package com.vironit.pharmacy.service.adminService;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminService<T> {

    @Transactional
    long save(T t);

    @Transactional
    void update(T t);

    @Transactional
    void delete(long id);
}
