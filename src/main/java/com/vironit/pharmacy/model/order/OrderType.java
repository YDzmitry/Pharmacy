package com.vironit.pharmacy.model.order;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ordertype")
public class OrderType extends BaseEntity{

    @Column(name = "type")
    private String type;

    public OrderType(String type) {
        this.type = type;
    }

    public OrderType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
