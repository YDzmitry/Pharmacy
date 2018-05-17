package com.vironit.pharmacy.service.adminService;

import com.vironit.pharmacy.dao.medicineDao.IndicatorToUseDao;
import com.vironit.pharmacy.model.medicine.IndicatorToUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AdminServiceIndicatorToUse implements AdminService<IndicatorToUse> {

    @Autowired
    private IndicatorToUseDao indicatorToUseDao;

    @Override
    public long save(IndicatorToUse indicatorToUse) {
        return indicatorToUseDao.create(indicatorToUse);
    }

    @Override
    public void update(IndicatorToUse indicatorToUse) {
        indicatorToUseDao.update(indicatorToUse);
    }

    @Override
    public void delete(long id) {
        indicatorToUseDao.delete(id);
    }
}
