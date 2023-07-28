package com.example.OrderManagement.Mine.entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
@TypeDefs({@TypeDef(name="json",typeClass = JsonType.class)})
public class Customer {
    @Id
    @Column(name = "customer_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    @Column(name = "customer_name",length=100,nullable = false)
    private String customerName;
    @Column(name = "customer_address",length=255)
    private String customerAddress;
    @Column(name = "salary",length = 10)
    private double salary;
    @Type(type = "json")
    @Column(name="contact_numbers",length=10,columnDefinition = "json")
    private ArrayList contactNumbers;
    @Column(name = "nic",length = 10)
    private String nic;
    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;
    @OneToMany(mappedBy = "customers")
    private Set<Order> orders;
}
