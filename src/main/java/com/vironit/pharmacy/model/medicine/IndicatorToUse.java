package com.vironit.pharmacy.model.medicine;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "indicatorstouse")
public class IndicatorToUse extends BaseEntity{

    @Column(name = "indicator")
    private String indicator;

    @ManyToMany(mappedBy = "indicatorsToUseList")
    private List<Medicine> medicineList;

    public IndicatorToUse(String indicator) {
        this.indicator = indicator;
    }

    public IndicatorToUse() {
    }

    public String getIndicator() {
        return indicator;
    }
}
