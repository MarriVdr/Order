package com.example.order.service.items;

import com.example.order.repository.DTO.ItemDTO;
import com.example.order.repository.items.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {

    public ItemDTO toDTO(Item item){
        return new ItemDTO(item.getItemId(), item.getName(), item.getDescription(), item.getPrice(), item.getStockAmount());
    }

    public List<ItemDTO> toDTO(List<Item> items){
        return items.stream().map(this::toDTO).toList();
    }


}
