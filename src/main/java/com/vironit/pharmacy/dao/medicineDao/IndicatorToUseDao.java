package com.vironit.pharmacy.dao.medicineDao;

import com.vironit.pharmacy.model.medicine.IndicatorToUse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndicatorToUseDao implements MainComponentMedicineDao<IndicatorToUse> {

    private static final Logger logger = LogManager.getLogger(ManufactureDao.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long create(IndicatorToUse indicatorToUse) {
        Long id = (Long) sessionFactory.getCurrentSession().save(indicatorToUse);
        logger.info("IndicatorToUse saved successfully, IndicatorToUse Details=" + indicatorToUse);
        return id;
    }

    @Override
    public void update(IndicatorToUse indicatorToUse) {
        sessionFactory.getCurrentSession().update(indicatorToUse);
        logger.info("IndicatorToUse updated successfully, IndicatorToUse Details=" + indicatorToUse);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(IndicatorToUse.class, id));
        logger.info("IndicatorToUse deleted successfully");
    }
}
