package com.example.OrderManagement.Mine.Service.impl;

import com.example.OrderManagement.Mine.Service.ItemService;
import com.example.OrderManagement.Mine.dto.ItemDTO;
import com.example.OrderManagement.Mine.dto.request.RequestItemSaveDTO;
import com.example.OrderManagement.Mine.entity.Item;
import com.example.OrderManagement.Mine.exception.NotFoundException;
import com.example.OrderManagement.Mine.repo.ItemRepo;
import com.example.OrderManagement.Mine.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void addCustomer(RequestItemSaveDTO requestItemSaveDTO){
        Item item = itemMapper.requestDtoToEntity(requestItemSaveDTO);
        item.setActiveState(false);
        if(!itemRepo.existsById(item.getItemID())){
            itemRepo.save(item);
            System.out.println("saved");
        }

    }

    @Override
    public List<ItemDTO> getItemByName(String itemName){
        List<Item> items = itemRepo.findAllByItemName(itemName);
        List<ItemDTO> itemDTOS = itemMapper.requestEntityListToDtoList(items);
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAllByActiveStateIs(false);

        if (items.size() > 0) {
            List<ItemDTO> itemDTOS = itemMapper.requestEntityListToDtoList(items);
            return itemDTOS;
        } else {
            throw new NotFoundException("No data found");
        }

    }

}
