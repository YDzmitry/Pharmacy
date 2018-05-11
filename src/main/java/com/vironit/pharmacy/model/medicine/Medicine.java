package com.vironit.pharmacy.model.medicine;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "medicine_effecttouse",
            joinColumns = @JoinColumn(name = "medicine_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "effect_id", referencedColumnName = "id")
    )
    private Set<EffectToUse> effectToUseList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "medicine_indicatorstouse",
            joinColumns = @JoinColumn(name = "medicine_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "indicator_id", referencedColumnName = "id")
    )
    private Set<IndicatorToUse> indicatorsToUseList;


    public Medicine(String description, boolean receiptIsNeed, int price, Set<EffectToUse> effectToUseList, Set<IndicatorToUse> indicatorsToUseList) {
        this.description = description;
        this.receiptIsNeed = receiptIsNeed;
        this.price = price;
        this.effectToUseList = effectToUseList;
        this.indicatorsToUseList = indicatorsToUseList;
    }

    public Medicine() {
    }

    public String getDescription() {
        return description;
    }

    public Boolean getReceiptIsNeed() {
        return receiptIsNeed;
    }

    public Integer getPrice() {
        return price;
    }

    public Manufacture getManufactor() {
        return manufactor;
    }

    public Set<EffectToUse> getEffectToUseList() {
        return effectToUseList;
    }

    public Set<IndicatorToUse> getIndicatorsToUseList() {
        return indicatorsToUseList;
    }
}
