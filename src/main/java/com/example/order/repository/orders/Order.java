package com.example.order.repository.orders;

import com.example.order.repository.items.Item;

import java.time.LocalDate;

public class Order {
    private final int orderNumber;
    private final Item item;
    private final String itemId;
    private final int amount;
    private final LocalDate shippingDate;
    public static int counter = 1;

    public Order(Item item, int amount) {
        this.orderNumber = counter +1;
        this.item = item;
        this.itemId = item.getItemId();
        this.amount = amount;
        this.shippingDate = getShippingDate(item);
        counter++;
    }

    public LocalDate getShippingDate(Item item){
        if (item.getStockAmount() <= 0) {
            return LocalDate.now().plusDays(7);
        }
        return LocalDate.now().plusDays(1);
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

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
