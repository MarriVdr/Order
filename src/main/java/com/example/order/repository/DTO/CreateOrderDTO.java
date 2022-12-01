package com.example.order.repository.DTO;

import com.example.order.repository.items.Item;

public record CreateOrderDTO(Item item, int amount) {
}
