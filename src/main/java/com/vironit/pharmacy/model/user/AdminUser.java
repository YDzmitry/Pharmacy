package com.vironit.pharmacy.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class AdminUser extends User {
}
