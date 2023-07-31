package com.example.OrderManagement.Mine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private int itemID;
    private String itemName;

    private double balanceQty;
    private double supplierPrice;
    private double sellerPrice;
    private boolean activeState;

}
