package com.vironit.pharmacy.service;


import com.vironit.pharmacy.dao.medicineDao.ManufactureDao;
import com.vironit.pharmacy.model.medicine.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class AdminServiceManufacture {

    @Autowired
    private ManufactureDao manufactureDao;

    @Transactional
    public long save(Manufacture manufacture) {
        return manufactureDao.create(manufacture);
    }

    public List<Manufacture> list() {
        return manufactureDao.getAll();
    }

    public Manufacture getByPK(long id) {
        return manufactureDao.getByPK(id);
    }

    @Transactional
    public void update(Manufacture manufacture) {
        manufactureDao.update(manufacture);
    }

    @Transactional
    public void delete(long id) {
        manufactureDao.delete(id);
    }
}
