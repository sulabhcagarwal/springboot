package com.shopping.Items.repository;

import com.shopping.Items.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findById(Integer id);
    List<Item> findAll();
    Item save(Item item);

}
