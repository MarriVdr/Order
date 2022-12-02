package com.example.order.API;

import com.example.order.repository.items.ItemRepository;
import com.example.order.service.itemService.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;

//    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
//    @Test

}