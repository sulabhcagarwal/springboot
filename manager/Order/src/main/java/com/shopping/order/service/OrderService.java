package com.shopping.order.service;

import com.shopping.order.entity.Cart;
import com.shopping.order.entity.Item;
import com.shopping.order.repository.OrderRepository;
import com.shopping.order.request.CartResponse;
import com.shopping.order.request.OrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CartResponse addOrder(OrderRequest orderRequest){
        var itemSet = new HashSet<Item>();
        orderRequest.itemIds().stream().forEach(id -> {
            var item = new Item();
            item.setItemId(id);
            itemSet.add(this.itemService.saveItem(item));
        });
        var cartResponse = getCartResponse(orderRequest, itemSet);
        return cartResponse;
    }

    private CartResponse getCartResponse(OrderRequest orderRequest, HashSet<Item> itemSet) {
        var cartDao = new Cart();
        cartDao.setExecuted(false);
        cartDao.setUserId(orderRequest.userId());
        cartDao.setItems(itemSet);
        var savedCart = this.orderRepository.save(cartDao);
        var itemIds = savedCart.getItems().stream().map(i -> i.getItemId()).toList();
        var cartResponse = new CartResponse(savedCart.getCartId(),savedCart.getUserId(), savedCart.getExecuted(), itemIds);
        return cartResponse;
    }

    @Transactional
    public Cart updateOrder(OrderRequest orderRequest){
        var itemSet = new HashSet<Item>();
        orderRequest.itemIds().stream().forEach(id -> {
            var item = new Item();
            item.setItemId(id);
            itemSet.add(this.itemService.saveItem(item));
        });
        var cartDao = this.orderRepository.findById(orderRequest.id()).get();
        cartDao.getItems().addAll(itemSet);
        return this.orderRepository.save(cartDao);
    }

    public boolean deleteOrder(OrderRequest orderRequest){
        var cartDao = this.orderRepository.findById(orderRequest.id());
        if(cartDao.isPresent()){
            this.orderRepository.delete(cartDao.get());
            return true;
        }else return false;
    }
}
