package com.vironit.pharmacy.dao;


import com.vironit.pharmacy.dao.userDao.EnumDao;
import com.vironit.pharmacy.model.order.OrderType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class OrderTypeDao implements EnumDao<OrderType> {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderType> getAll() throws IOException {
        return sessionFactory.getCurrentSession().createQuery("from OrderType").list();
    }

}