package com.example.order.repository.DTO;

import com.example.order.repository.items.Item;

import java.util.Objects;

public class ItemDTO {
    private String id;
    private final String name;
    private final String description;
    private int price;
    private int stockAmount;

    public ItemDTO(String id, String name, String description, int price, int stockAmount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return price == itemDTO.price && stockAmount == itemDTO.stockAmount && Objects.equals(id, itemDTO.id) && Objects.equals(name, itemDTO.name) && Objects.equals(description, itemDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, stockAmount);
    }
}
