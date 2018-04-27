package com.vironit.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "typeaccount")
public class TypeAccount extends BaseEntity{


    @Column (name = "type")
    private String type;


    public TypeAccount(String type) {
        this.type = type;
    }

    public TypeAccount() {
    }

    public String getType() {
        return type;
    }


}
