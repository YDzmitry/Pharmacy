package com.vironit.pharmacy.dao.userDao;

import com.vironit.pharmacy.dao.EnumDao;
import com.vironit.pharmacy.model.user.TypeAccount;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class TypeAccountDao implements TypeAccountD {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<TypeAccount> getAll() throws IOException {
        return sessionFactory.getCurrentSession().createQuery("from TypeAccount").list();
    }


}
