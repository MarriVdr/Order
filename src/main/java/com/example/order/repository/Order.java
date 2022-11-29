package com.example.order.repository;

import java.time.LocalDate;

public class Order {
    private final int orderNumber;
    private final String itemId;
    private final int amount;
    private final LocalDate localDate;
    private int counter = 0;

    public Order(String itemId, int amount, LocalDate localDate) {
        this.orderNumber = counter +1;
        this.itemId = itemId;
        this.amount = amount;
        this.localDate = localDate;
        counter++;
    }
}
