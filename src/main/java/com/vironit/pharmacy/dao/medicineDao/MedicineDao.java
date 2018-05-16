package com.vironit.pharmacy.dao.medicineDao;

import com.vironit.pharmacy.dao.Dao;
import com.vironit.pharmacy.model.medicine.Medicine;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MedicineDao implements Dao<Medicine> {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Long create(Medicine medicine) {
        Long id = (Long) sessionFactory.getCurrentSession().save(medicine);
       return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Medicine> getAll() {
        List<Medicine> medicineList = sessionFactory.getCurrentSession().createQuery("from Medicine ").list();
        return medicineList;
    }

    @Override
    public Medicine getByPK(Long key) {
        Medicine medicine = sessionFactory.getCurrentSession().get(Medicine.class, key);
        return medicine;
    }

    @Override
    public void update(Medicine medicine) {
        sessionFactory.getCurrentSession().update(medicine);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Medicine.class, id));
    }
}
