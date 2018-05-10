package com.vironit.pharmacy.model.medicine;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "indicatorstouse")
public class IndicatorToUse extends BaseEntity{

    @Column(name = "indicator")
    private String indicator;

    public IndicatorToUse(String indicator) {
        this.indicator = indicator;
    }

    public IndicatorToUse() {
    }
}
