package com.vironit.pharmacy.service.adminService;

import com.vironit.pharmacy.dao.medicineDao.EffectToUseDao;
import com.vironit.pharmacy.model.medicine.EffectToUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AdminServiceEffectToUse implements AdminService<EffectToUse> {

    @Autowired
    private EffectToUseDao effectToUseDao;

    @Transactional
    @Override
    public long save(EffectToUse effectToUse) {
        return effectToUseDao.create(effectToUse);
    }

    @Override
    public void update(EffectToUse effectToUse) {
        effectToUseDao.update(effectToUse);
    }

    @Override
    public void delete(long id) {
        effectToUseDao.delete(id);
    }
}
