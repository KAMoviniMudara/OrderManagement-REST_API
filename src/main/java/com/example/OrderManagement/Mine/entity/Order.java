package com.example.OrderManagement.Mine.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@TypeDefs({@TypeDef(name = "json",typeClass = JsonTypeId.class)})
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    @Id
    @Column(name = "order_id" , length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;

    @Column(name="order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total" , nullable = false)
    private double total;

    @ManyToOne
    @Column(name = "customer_id" , nullable = false)
    private Customer customers;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;

    public Order(Date date, Double total, Customer customers){
        this.date=date;
        this.total=total;
        this.customers=customers;
    }

}
