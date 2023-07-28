package com.example.OrderManagement.Mine.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
    private int itemID;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellerPrice;
    private boolean activeState;

}
