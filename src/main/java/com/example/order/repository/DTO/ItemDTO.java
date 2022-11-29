package com.example.order.repository.DTO;

import java.util.UUID;

public class ItemDTO {
    private final String name;
    private final String description;
    private int price;
    private int amount;

    public ItemDTO(String name, String description, int price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
