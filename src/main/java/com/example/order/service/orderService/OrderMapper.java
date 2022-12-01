package com.example.order.service.orderService;

import com.example.order.repository.DTO.OrderDTO;
import com.example.order.repository.orders.Order;

import java.util.List;

public class OrderMapper {

    public OrderDTO toDTO(Order order){
        return new OrderDTO(order.getOrderNumber(), order.getItemGroups());
    }

    public List<OrderDTO> toDTO(List<Order> orders){
        return orders.stream().map(this::toDTO).toList();
    }
}
