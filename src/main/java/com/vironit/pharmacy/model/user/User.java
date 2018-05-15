package com.vironit.pharmacy.model.user;


import com.vironit.pharmacy.model.BaseEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
//
//@Entity
//@Table(name = "users")
@MappedSuperclass
public class User extends BaseEntity {

    @NaturalId
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "typeaccount_id")
    private TypeAccount typeAccount;


    public User(String login, String password, TypeAccount typeAccount, Role role) {
        this.login = login;
        this.password = password;
        this.typeAccount = typeAccount;
        this.role = role;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role.getRole();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }
}
