package com.example.order.repository.items;

import java.time.LocalDate;

public class Order {
    private final int orderNumber;
    private final String itemId;
    private final int amount;
    private final LocalDate localDate;

    public Order(String itemId, int amount, LocalDate localDate) {
        int counter = 1;
        this.orderNumber = counter +1;
        this.itemId = itemId;
        this.amount = amount;
        this.localDate = localDate;
        counter++;
    }
}
