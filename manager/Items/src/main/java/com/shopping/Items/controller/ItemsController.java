package com.shopping.Items.controller;

import com.shopping.Items.entity.Item;
import com.shopping.Items.request.ItemRequest;
import com.shopping.Items.service.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemsController {

    private final ItemService itemService;
    private final Logger logger = LogManager.getLogger(ItemsController.class);

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems(){
        try{
            return ResponseEntity.ok(this.itemService.findAll());
        }catch (Exception e){
            logger.error("Error while getting Items", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/items")
    public ResponseEntity<List<Item>> addItem(@RequestBody List<ItemRequest> itemRequest){
        try{
            this.itemService.addItems(itemRequest);
            return ResponseEntity.ok(this.itemService.findAll());
        }catch (Exception e){
            logger.error("Error while adding Items", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
