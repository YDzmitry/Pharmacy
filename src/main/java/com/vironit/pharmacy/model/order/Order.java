package com.vironit.pharmacy.model.order;

import com.vironit.pharmacy.model.BaseEntity;
import com.vironit.pharmacy.model.medicine.Medicine;
import com.vironit.pharmacy.model.user.UserAddress;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "order_type")
    private OrderType orderType;

    @OneToOne
    @JoinColumn(name = "address_id")
    private UserAddress address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_medicine",
            joinColumns = @JoinColumn(name = "medicine_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id")
    )
    private List<Medicine> medicineList;


    public Order(Double amount, OrderType orderType, UserAddress address, List<Medicine> medicineList) {
        this.amount = amount;
        this.orderType = orderType;
        this.address = address;
        this.medicineList = medicineList;
    }

    public Order() {
    }
}
