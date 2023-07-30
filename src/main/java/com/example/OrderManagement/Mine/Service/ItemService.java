package com.example.OrderManagement.Mine.Service;

import com.example.OrderManagement.Mine.dto.ItemDTO;
import com.example.OrderManagement.Mine.dto.request.RequestItemSaveDTO;

import java.util.List;

public interface ItemService {
    void addCustomer(RequestItemSaveDTO itemDTO);
    List<ItemDTO> getItemByName(String itemName);
    List<ItemDTO> getAllItems();
}
