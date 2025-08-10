package com.shopping.order.repository;

import com.shopping.order.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAll();
    Optional<Cart> findById(Integer id);
}
