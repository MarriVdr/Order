package com.example.order.repository.DTO;

import java.time.LocalDate;

public class OrderDTO {
    private final int orderNumber;
    private final String itemId;
    private final int amount;
    private final LocalDate localDate;

    public OrderDTO(int orderNumber, String itemId, int amount, LocalDate localDate) {
        this.orderNumber = orderNumber;
        this.itemId = itemId;
        this.amount = amount;
        this.localDate = localDate;

    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
