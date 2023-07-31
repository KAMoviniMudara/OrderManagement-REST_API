package com.example.OrderManagement.Mine.util.mappers;

import com.example.OrderManagement.Mine.dto.ItemDTO;
import com.example.OrderManagement.Mine.dto.request.RequestItemSaveDTO;
import com.example.OrderManagement.Mine.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel="spring")
public interface ItemMapper {
    Item requestDtoToEntity(RequestItemSaveDTO requestItemSaveDTO);
    List<ItemDTO> requestEntityListToDtoList(List<Item>items);
    List<ItemDTO> requestPagetoList(Page<Item> items);
}
