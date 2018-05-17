package com.vironit.pharmacy.service.order;

import com.vironit.pharmacy.dao.orderDao.OrderDao;
import com.vironit.pharmacy.model.order.Order;
import com.vironit.pharmacy.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService implements MainService<Order> {

    @Autowired
    OrderDao orderDao;

    @Transactional
    @Override
    public long save(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Order getByPK(long id) {
        return orderDao.getByPK(id);
    }

    @Override
    public List<Order> list() {
        return orderDao.getAll();
    }

    @Transactional
    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Transactional
    @Override
    public void delete(long id) {
        orderDao.delete(id);
    }
}
