package com.vironit.pharmacy.model.medicine;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "effecttouse")
public class EffectToUse extends BaseEntity {

    @Column(name = "effect")
    private String effect;

    @ManyToMany(mappedBy = "effectToUseList")
    private List<Medicine> medicineList;

    public EffectToUse(String effect) {
        this.effect = effect;
    }

    public EffectToUse() {
    }

    public String getEffect() {
        return effect;
    }
}
