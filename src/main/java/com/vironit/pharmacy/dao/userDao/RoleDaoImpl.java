package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.model.user.Role;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private static final Logger logger = LogManager.getLogger(RoleDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Role> getAll() throws IOException {
        logger.info("Roles has been uploaded");
        return sessionFactory.getCurrentSession().createQuery("from Role").list();
    }
}
