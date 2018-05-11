package com.vironit.pharmacy.model.medicine;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "effecttouse")
public class EffectToUse extends BaseEntity {

    @Column(name = "effect")
    private String effect;

    public EffectToUse(String effect) {
        this.effect = effect;
    }

    public EffectToUse() {
    }

    public String getEffect() {
        return effect;
    }
}
