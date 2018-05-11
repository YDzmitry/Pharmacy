package com.vironit.pharmacy.service;


import com.vironit.pharmacy.dao.medicineDao.MedicineDao;
import com.vironit.pharmacy.model.medicine.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("request")
//@Transactional(readOnly = true)
public class MedicineService implements MainService<Medicine> {

    @Autowired
    MedicineDao medicineDao;

    @Override
    public long save(Medicine medicine) {
        return medicineDao.create(medicine);
    }

    @Override
    public Medicine getByPK(long id) {
        return medicineDao.getByPK(id);
    }

    @Override
    public List<Medicine> list() {
        return medicineDao.getAll();
    }

    @Override
    public void update(Medicine medicine) {
        medicineDao.update(medicine);
    }

    @Override
    public void delete(long id) {
        medicineDao.delete(id);
    }
}
