package com.shopping.order.cache;

import com.shopping.order.entity.Item;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

@Controller
public class ItemCache {

    public Map<Integer, Item> items;

    public ItemCache(){
        items = new HashMap<>();
        Item item = new Item();
        item.setItemId(1);
        items.put(item.getItemId(), item);
        Executors.newVirtualThreadPerTaskExecutor();
    }

    public boolean itemAvailable(Integer itemId){
        return items.containsKey(itemId);
    }
}
