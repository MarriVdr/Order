package com.example.order.API;

import com.example.order.repository.DTO.CreateCustomerDTO;
import com.example.order.repository.DTO.CustomerDTO;
import com.example.order.repository.DTO.ItemDTO;
import com.example.order.repository.DTO.UpdateItemDTO;
import com.example.order.service.itemService.ItemService;
import com.example.order.service.users.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eurder")
public class OrderController {

    private ItemService itemService;

    public OrderController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO createItem(@RequestBody ItemDTO itemToCreate) {
        return itemService.addItemToInventory(itemToCreate);
    }

    @PutMapping(path= "/items/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO updateItemById(@PathVariable String id, @RequestBody UpdateItemDTO updateItemDTO){
        return itemService.updateItem(id, updateItemDTO);
    }

    @GetMapping(path = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDTO> getListOfAllItems(){
        return itemService.getAllItems();
    }


}
