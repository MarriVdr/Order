package com.example.order.service.items;

import com.example.order.exceptions.FieldIsEmptyException;
import com.example.order.exceptions.IdDoesNotExistsException;
import com.example.order.exceptions.ItemAlreadyExistsException;
import com.example.order.repository.DTO.ItemDTO;
import com.example.order.repository.DTO.UpdateItemDTO;
import com.example.order.repository.items.Item;
import com.example.order.repository.items.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTO addItemToInventory(ItemDTO itemToAdd) {
        if (itemToAdd.getName() == null) {
            throw new FieldIsEmptyException("Please enter a valid item name.");
        }
        Item newItem = new Item(itemToAdd.getName(), itemToAdd.getDescription(), itemToAdd.getPrice(), itemToAdd.getAmount());
        if (itemRepository.containsItem(newItem)) {
            throw new ItemAlreadyExistsException("Item already listed in inventory.");
        }
        itemRepository.addItem(newItem);
        return itemMapper.toDTO(newItem);
    }
    public List<ItemDTO> getAllItems(){
        return itemMapper.toDTO(itemRepository.getItems());
    }

    public ItemDTO getItemById(String id){
        return itemMapper.toDTO(itemRepository.findItemById(id).orElseThrow(() -> new IdDoesNotExistsException("Item with id " + id + " does not exist.")));
    }


    public ItemDTO updateItem(String id, UpdateItemDTO itemToUpdate) {
        Optional<Item> item = itemRepository.findItemById(id);
        if(item.isEmpty()){
            throw new IdDoesNotExistsException("Item id not found.");
        }
        Item itemNew = item.get();
        itemNew.setDescription(itemToUpdate.getDescription());
        itemNew.setPrice(itemToUpdate.getPrice());
        itemNew.setAmount(itemToUpdate.getAmount());
        return itemMapper.toDTO(itemNew);
    }

}
