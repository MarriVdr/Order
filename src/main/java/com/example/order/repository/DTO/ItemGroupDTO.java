package com.example.order.repository.DTO;

import com.example.order.repository.items.Item;

import java.time.LocalDate;

public record ItemGroupDTO(Item item, String itemId, double amount, LocalDate shippingDate) {
}
