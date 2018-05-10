package com.vironit.pharmacy.model.medicine;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "receiptisneed")
    private Boolean receiptIsNeed;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufactor;

    @ManyToMany
    @JoinTable(name = "medicine_effecttouse",
            joinColumns = @JoinColumn(name = "medicine_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "effect_id",referencedColumnName = "id")
    )
    private List<EffectToUse> effectToUseList;

    @ManyToMany
    @JoinTable(name = "medicine_indicatorstouse",
            joinColumns = @JoinColumn(name = "medicine_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "indicator_id",referencedColumnName = "id")
    )
    private List<IndicatorToUse> indicatorsToUseList;


    public Medicine(String description, boolean receiptIsNeed, int price, List<EffectToUse> effectToUseList, List<IndicatorToUse> indicatorsToUseList) {
        this.description = description;
        this.receiptIsNeed = receiptIsNeed;
        this.price = price;
        this.effectToUseList = effectToUseList;
        this.indicatorsToUseList = indicatorsToUseList;
    }

    public Medicine() {
    }
}
