package com.vironit.pharmacy.model.user;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "typeaccount")
public class TypeAccount extends BaseEntity {


    @Column(name = "type")
    private String type;

    public TypeAccount(String type) {
        this.type = type;
    }

    public TypeAccount() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
