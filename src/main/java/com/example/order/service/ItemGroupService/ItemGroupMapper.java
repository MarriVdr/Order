package com.example.order.service.ItemGroupService;

import com.example.order.repository.DTO.ItemGroupDTO;
import com.example.order.repository.orders.ItemGroup;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemGroupMapper {
    public ItemGroupDTO toDTO(ItemGroup itemgroup){
        return new ItemGroupDTO(itemgroup.getItem(), itemgroup.getItemId(), itemgroup.getAmount(), itemgroup.getShippingDate());
    }

    public List<ItemGroupDTO> toDTO(List<ItemGroup> itemGroups){
        return itemGroups.stream().map(this::toDTO).toList();
    }
}


