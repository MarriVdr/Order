package com.example.order.repository.orders;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orderHistory;

    public OrderRepository() {
        this.orderHistory = new ArrayList<>();
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public Order addOrder(Order order){
        orderHistory.add(order);
        return order;
    }


}
