package com.example.OrderManagement.Mine.Service;


import com.example.OrderManagement.Mine.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestItemSaveDTO);

}
