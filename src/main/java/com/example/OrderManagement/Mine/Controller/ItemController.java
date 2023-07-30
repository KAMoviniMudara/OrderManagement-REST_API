package com.example.OrderManagement.Mine.Controller;

import com.example.OrderManagement.Mine.Service.ItemService;
import com.example.OrderManagement.Mine.dto.ItemDTO;
import com.example.OrderManagement.Mine.dto.request.RequestItemSaveDTO;
import com.example.OrderManagement.Mine.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String SaveItem(@RequestBody RequestItemSaveDTO requestItemSaveDTO) {
        itemService.addCustomer(requestItemSaveDTO);
        return "Saved";
    }

    @GetMapping(path = "/get-by-name", params = "name")
    public List<ItemDTO> getItemByName(@RequestParam(value = "name") String itemName) {
        List<ItemDTO> itemDTOList = itemService.getItemByName(itemName);
        return itemDTOList;
    }

    @GetMapping(path = "/get-all-item")
    public ResponseEntity<StandardResponse> getAllItems() {
        List<ItemDTO> itemDTOS = itemService.getAllItems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"SUCCESS",itemDTOS),HttpStatus.OK
        );
    }

}
