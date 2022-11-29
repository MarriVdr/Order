package com.example.order.repository;

import java.time.LocalDate;

public class Order {
    private final String orderNumber;
    private final String itemId;
    private final int amount;
    private final LocalDate localDate;

    public Order(String itemId, int amount, LocalDate localDate) {
//        this.orderNumber = orderNumber;
        this.itemId = itemId;
        this.amount = amount;
        this.localDate = localDate;
    }
}
