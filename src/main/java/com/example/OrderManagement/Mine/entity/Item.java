package com.example.OrderManagement.Mine.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@TypeDefs({@TypeDef(name = "json",typeClass = JsonTypeId.class)})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemID;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

   

    @Column(name = "balance_qty",length = 50,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 50,nullable = false)
    private double supplierPrice;

    @Column(name = "seller_price",length = 50,nullable = false)
    private double sellerPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;

}
