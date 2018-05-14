package com.vironit.pharmacy.model.user;

import com.vironit.pharmacy.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
public class UserAddress extends BaseEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserAddress(String country, String city, String street, String house, User user) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.user = user;
    }

    public UserAddress() {
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public User getUser() {
        return user;
    }
}
