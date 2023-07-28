package com.example.OrderManagement.Mine.entity;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@TypeDefs({@TypeDef(name = "json",typeClass = JsonType.class)})
public class OrderDetails {
    @Id
    @Column(name = "order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsID;
    @Column(name = "item_name",length=100,nullable = false)
    private String itemName;
    @Column(name = "qty",length=50,nullable = false)
    private Double qty;

    @Column(name = "item_name",length=100,nullable = false)
    private Double amount;
    private Order orders;
    private Item items;
}
