package com.vironit.pharmacy.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @NaturalId
    @Column(name = "login")
    @Getter
    @Setter
    private String login;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    @Getter
    @Setter
    private Role role;

    @ManyToOne
    @JoinColumn(name = "typeaccount_id")
    @Getter
    @Setter
    private TypeAccount typeAccount;


    public User(String login, String password, TypeAccount typeAccount, Role role) {
        this.login = login;
        this.password = password;
        this.typeAccount = typeAccount;
        this.role = role;
    }

    public User() {
    }
}
