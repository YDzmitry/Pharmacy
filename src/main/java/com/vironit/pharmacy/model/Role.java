package com.vironit.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Column(name = "userrole")
    private String role;

    public Role(Integer id,String role) {
        this.role = role;
    }

    public Role() {
    }

    public String getRole() {
        return role;
    }
}