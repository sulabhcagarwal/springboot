package com.shopping.Items.service;

import com.shopping.Items.entity.Item;
import com.shopping.Items.repository.ItemRepository;
import com.shopping.Items.request.ItemRequest;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void addItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void addItems(List<ItemRequest> itemRequests){
        itemRequests.stream().forEach(item -> {
            var itemDao = new Item();
            itemDao.setName(item.name());
            itemDao.setVersion(item.version());
            itemDao.setQuantity(item.quantity());
            itemRepository.save(itemDao);
        });

    }

    public List<Item> findAll(){
        return this.itemRepository.findAll();
    }

    public Item findById(@NonNull Integer id){
        return this.itemRepository.findById(id).get();
    }
}
