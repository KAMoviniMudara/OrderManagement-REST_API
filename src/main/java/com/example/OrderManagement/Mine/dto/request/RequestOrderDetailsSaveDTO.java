package com.example.OrderManagement.Mine.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int orders;
    private int items;


}
