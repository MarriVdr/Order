package com.example.order.repository.DTO;

public class UpdateItemDTO {

    private String description;
    private int price;
    private int amount;

    public UpdateItemDTO(String description, int price, int amount) {
        this.description = description;
        this.price = price;
        this.amount = amount;
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
