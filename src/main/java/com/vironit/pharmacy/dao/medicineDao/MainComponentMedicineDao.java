package com.vironit.pharmacy.dao.medicineDao;

public interface MainComponentMedicineDao<T> {

    Long create(T t);

    void update(T t);

    void delete(long id);
}
