package com.vironit.pharmacy.dao.orderDao;

import com.vironit.pharmacy.dao.Dao;
import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.order.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao implements Dao<Order> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long create(Order order) {
        Long id = (Long) sessionFactory.getCurrentSession().save(order);
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        List<Order> orderList = sessionFactory.getCurrentSession().createQuery("from Order").list();
        return orderList;
    }

    @Override
    public Order getByPK(Long key) throws CustomGenericException {
        Order order = sessionFactory.getCurrentSession().get(Order.class, key);
        return order;
    }

    @Override
    public void update(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().get(Order.class, id);
    }
}