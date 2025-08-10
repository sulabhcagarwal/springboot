package com.shopping.order.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id @GeneratedValue
    private Integer cartId;
    private Integer userId;
    private Boolean executed;

    @ManyToMany
    @JoinTable(name = "cart_item",
    joinColumns = @JoinColumn(name = "cartId"),
    inverseJoinColumns = @JoinColumn(name = "itemId"))
    private Set<Item> items = new HashSet<>();

    public Integer getUserId() {
        return userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Boolean getExecuted() {
        return executed;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setExecuted(Boolean executed) {
        this.executed = executed;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
