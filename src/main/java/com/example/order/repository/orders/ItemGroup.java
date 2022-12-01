package com.example.order.repository.orders;

import com.example.order.repository.items.Item;

import java.time.LocalDate;

public class ItemGroup {
    private final Item item;
    private final String itemId;
    private double amount;
    private LocalDate shippingDate;



    public ItemGroup(Item item, int amount) {

        this.item = item;
        this.itemId = item.getItemId();
        this.amount = amount;
        this.shippingDate = setShippingDate(item.getStockAmount());

    }

    public Item getItem() {
        return item;
    }

    public LocalDate setShippingDate(int stockAmount){
        if (stockAmount <= 0) {
        return LocalDate.now().plusDays(7);
        }
        return LocalDate.now().plusDays(1);

    }
    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public double getAmount() {
        return amount;
    }


}
