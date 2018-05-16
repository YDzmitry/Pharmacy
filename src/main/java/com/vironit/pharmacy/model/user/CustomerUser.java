package com.vironit.pharmacy.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class CustomerUser extends MainUser {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customerUser",fetch = FetchType.EAGER)
    @Column
    private Set<UserAddress> addressDeliveryList;

    public CustomerUser() {
    }

    public CustomerUser(String login, String password, TypeAccount typeAccount, Role role, String name, String surname, Double balance, String phone, Set<UserAddress> addressDeliveryList) {
        super(login, password, typeAccount, role);
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.phone = phone;
        this.addressDeliveryList = addressDeliveryList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getBalance() {
        return balance;
    }

    public String getPhone() {
        return phone;
    }

    public Set<UserAddress> getAddressDeliveryList() {
        return addressDeliveryList;
    }
}
