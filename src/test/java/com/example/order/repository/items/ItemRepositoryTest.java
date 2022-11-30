package com.example.order.repository.items;

import com.example.order.exceptions.FieldIsEmptyException;
import com.example.order.exceptions.ItemAlreadyExistsException;
import com.example.order.repository.DTO.ItemDTO;
import com.example.order.repository.DTO.UpdateItemDTO;
import com.example.order.service.items.ItemMapper;
import com.example.order.service.items.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ItemRepositoryTest {
    private ItemRepository testItemRepository;
    private ItemService testItemService;
    private ItemMapper testItemMapper;
    private Item item1;
    private Item item2;

    @BeforeEach
    void setupItems(){

        item1 = new Item("Greeny Pot", "For big plants.", 12, 20);
        item2 = new Item("Sunny Glasses", "For bright days", 10, 20);

        testItemRepository = new ItemRepository();
        testItemMapper = new ItemMapper();
        testItemService = new ItemService(testItemRepository, testItemMapper);

        testItemRepository.addItem(item1);
        testItemRepository.addItem(item2);
    }

    @Test
    void givenNewItemToAdd_whenItemAddedToRepository_returnCorrectList(){
        Item mouse = new Item("Laptop Mouse", "For Laptops", 15, 20);

        testItemRepository.addItem(mouse);

        Assertions.assertTrue(testItemRepository.containsItem(mouse));

    }

    @Test
    void givenNewItemToAddWithoutName_whenItemAddedToRepository_returnFieldsEmptyException(){
        ItemDTO mouse = new ItemDTO("1", null, "For Laptops", 15, 20);

        Assertions.assertThrows(FieldIsEmptyException.class, () -> testItemService.addItemToInventory(mouse));

    }
    @Test
    void givenNewItemToAddThatAlreadyExists_whenItemAddedToRepository_returnItemAlreadyExistsException(){
        ItemDTO potPlant = new ItemDTO("2","Greeny Pot", "For big plants.", 12, 20);

        Assertions.assertThrows(ItemAlreadyExistsException.class, () -> testItemService.addItemToInventory(potPlant));

    }

    @Test
    void givenListOfItems_whenGettingListOfAllItems_returnCorrectList(){
        List<Item> expectedList = List.of(item1, item2);
        Assertions.assertTrue(testItemRepository.getItems().containsAll(expectedList));
    }


    @Test
    void givenItemToUpdate_whenNewInformation_returnUpdatedItem(){
        UpdateItemDTO itemWithNewFields = new UpdateItemDTO("Hi", 5, 6);
        String id = testItemRepository.getItems().get(0).getItemId();

        ItemDTO item = testItemService.updateItem(id, itemWithNewFields);
        Assertions.assertEquals(item1.getName(), item.getName());
        Assertions.assertEquals("Hi", item.getDescription());
        Assertions.assertEquals(5, item.getPrice());
        Assertions.assertEquals(6, item.getAmount());
    }
}