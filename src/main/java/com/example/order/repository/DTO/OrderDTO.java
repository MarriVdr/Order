package com.example.order.repository.DTO;

import com.example.order.repository.orders.ItemGroup;

import java.util.List;

public record OrderDTO(int orderNumber, List<ItemGroup> itemGroups) {

}
