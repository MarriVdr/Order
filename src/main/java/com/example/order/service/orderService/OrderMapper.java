package com.example.order.service.orderService;

import com.example.order.repository.DTO.OrderDTO;
import com.example.order.repository.orders.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order){
        return new OrderDTO(order.getOrderNumber(), order.getItemId(), order.getAmount(), order.getShippingDate());
    }

    public List<OrderDTO> toDTO(List<Order> orders){
        return orders.stream().map(this::toDTO).toList();
    }
}
