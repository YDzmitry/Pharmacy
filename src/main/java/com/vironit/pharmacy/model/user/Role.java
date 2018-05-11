package com.vironit.pharmacy.model.user;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "userrole")
    private String role;


    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}