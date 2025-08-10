package com.shopping.order.service;

import com.shopping.order.entity.Cart;
import com.shopping.order.entity.Item;
import com.shopping.order.repository.OrderRepository;
import com.shopping.order.request.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public OrderService(OrderRepository orderRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public List<Cart> getAllOrders(){
        return this.orderRepository.findAll();
    }

    public Cart updateOrder(OrderRequest orderRequest){
        var itemSet = new HashSet<Item>();
        orderRequest.itemIds().stream().forEach(id -> {
            var item = new Item();
            item.setItemId(id);
            itemSet.add(this.itemService.saveItem(item));
        });
        var cartDao = new Cart();
        cartDao.setExecuted(false);
        cartDao.setUserId(orderRequest.userId());
        cartDao.setItems(itemSet);
        return this.orderRepository.save(cartDao);
    }
}
