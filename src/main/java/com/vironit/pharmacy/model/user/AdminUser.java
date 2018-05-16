package com.vironit.pharmacy.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class AdminUser extends MainUser {

    public AdminUser(String login, String password, TypeAccount typeAccount, Role role) {
        super(login, password, typeAccount, role);

    }

    public AdminUser() {
    }
}
