package com.example.order.service.orderService;

import com.example.order.repository.items.ItemRepository;
import com.example.order.repository.orders.OrderRepository;
import com.example.order.service.ItemGroupService.ItemGroupMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ItemGroupMapper itemGroupMapper;
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    public OrderService(ItemGroupMapper itemGroupMapper, OrderRepository orderRepository, ItemRepository itemRepository) {
        this.itemGroupMapper = itemGroupMapper;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

//    public OrderDTO placingOrder(CreateOrderDTO createOrderDTO){
//        if(!itemRepository.containsItem(createOrderDTO.item())){
//            throw new ItemDoesNotExistsException("Item not found.");
//        }
//        ItemGroup newItemGroup = new ItemGroup(createOrderDTO.item(), createOrderDTO.amount());
//        return orderMapper.toDTO(orderRepository.addOrder(order));
//    }

//    public List<OrderDTO> placingAnOrder(List<CreateOrderDTO> orderList){
//
//    }
}
