package com.vironit.pharmacy.dao.medicineDao;

import com.vironit.pharmacy.model.medicine.Manufacture;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufactureDao implements MainComponentMedicineDao<Manufacture> {

    private static final Logger logger = LogManager.getLogger(ManufactureDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Manufacture manufacture) {
        Long id = (Long) sessionFactory.getCurrentSession().save(manufacture);
        logger.info("Manufacture saved successfully, Manufacture Details=" + manufacture);
        return id;
    }

    @Override
    public void update(Manufacture manufacture) {
        sessionFactory.getCurrentSession().update(manufacture);
        logger.info("Manufacture updated successfully, Manufacture Details=" + manufacture);

    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Manufacture.class, id));
        logger.info("Manufacture deleted successfully");
    }

    @SuppressWarnings("unchecked")
    public List<Manufacture> getAll() {
        List<Manufacture> manufactureList = sessionFactory.getCurrentSession().createQuery("from Manufacture").list();
        for (Manufacture manufacture : manufactureList) {
            logger.info("Manufacture list::" + manufacture);
        }
        return manufactureList;
    }

    public Manufacture getByPK(long id) {
        Manufacture manufacture = sessionFactory.getCurrentSession().get(Manufacture.class, id);
        logger.info("Manufacture loaded successfully, manufacture details=" + manufacture);
        return manufacture;
    }
}
