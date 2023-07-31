package com.example.OrderManagement.Mine.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestItemSaveDTO {
    private String itemName;

    private double balanceQty;
    private double supplierPrice;
    private double sellerPrice;
}
