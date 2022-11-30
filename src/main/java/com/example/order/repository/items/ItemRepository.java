package com.example.order.repository.items;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ItemRepository {
    private List<Item> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean containsItem(Item item) {
        return items.stream().anyMatch(item1 -> item1.getName().equals(item.getName()));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Optional<Item> findItemById(String id){
        return items.stream().filter(item -> item.getItemId().equals(id)).findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRepository that = (ItemRepository) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
