package com.example.order.repository.orders;

import java.util.List;

public class Order {
    private int orderNumber;
    private final List<ItemGroup> itemGroups;
    public static int counter = 1;

    public Order(int orderNumber, List<ItemGroup> itemGroups) {
        this.orderNumber = counter +1;
        this.itemGroups = itemGroups;
        counter++;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
