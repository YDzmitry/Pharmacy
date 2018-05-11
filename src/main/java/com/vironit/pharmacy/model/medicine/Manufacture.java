package com.vironit.pharmacy.model.medicine;


import com.vironit.pharmacy.model.BaseEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manufacture")
public class Manufacture extends BaseEntity {

    @NaturalId
    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    public Manufacture() {
    }

    public Manufacture(String description, String country, String city, String street, String house) {
        this.description = description;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getDescription() {
        return description;
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
}