package com.example.Shop.service;

import com.example.Shop.entity.OrderItems;

import java.util.Collection;

public interface OrderItemsService {
    void add(OrderItems item);

    void remove(Integer productId);

    Collection<OrderItems> getCartItem();

    void update(Integer productId, Integer quantity);

    Integer getCount();

    String getAmount();
}
