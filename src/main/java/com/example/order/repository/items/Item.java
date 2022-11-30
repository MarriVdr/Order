package com.example.order.repository.items;

import java.util.UUID;

public class Item {
    private final String itemId;
    private final String name;
    private String description;
    private int price;
    private int stockAmount;

    public Item(String name, String description, int price, int stockAmount) {
        this.itemId = UUID.randomUUID().toString();;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public String getItemId() {
        return itemId;
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

    public int getStockAmount() {
        return stockAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
