package com.vironit.pharmacy.service.adminService;


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
public class AdminServiceManufacture implements AdminService<Manufacture> {

    @Autowired
    private ManufactureDao manufactureDao;

    @Transactional
    @Override
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
    @Override
    public void update(Manufacture manufacture) {
        manufactureDao.update(manufacture);
    }

    @Transactional
    @Override
    public void delete(long id) {
        manufactureDao.delete(id);
    }
}
