package com.shopping.order.service;

import com.shopping.order.entity.Item;
import com.shopping.order.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item saveItem(Item item){
        return this.itemRepository.save(item);
    }
}
