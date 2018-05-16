package com.vironit.pharmacy.dao.medicineDao;

import com.vironit.pharmacy.model.medicine.EffectToUse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

@Repository
public class EffectToUseDao implements MainComponentMedicineDao<EffectToUse> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(EffectToUse effectToUse) {
        Long id = (Long) sessionFactory.getCurrentSession().save(effectToUse);
        return id;
    }

    @Override
    public void update(EffectToUse effectToUse) {
        sessionFactory.getCurrentSession().update(effectToUse);
     }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(EffectToUse.class, id));
    }
}
