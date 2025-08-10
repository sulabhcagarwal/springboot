package com.shopping.order.entity;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    private Integer itemId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

}
