package com.vironit.pharmacy.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class ManagerUser extends User {

    @Column(name = "passport")
    private String passport;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "level")
    private Integer level;

    public ManagerUser(String login, String password, TypeAccount typeAccount, Role role, String passport, Double balance, Integer level) {
        super(login, password, typeAccount, role);
        this.passport = passport;
        this.balance = balance;
        this.level = level;
    }


    public ManagerUser(){

    }
}
