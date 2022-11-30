package com.example.order.repository.orders;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<LocalDate, Order> orderHistory;

    public OrderRepository() {
        this.orderHistory = new HashMap<>();
//        orderHistory
    }
}
