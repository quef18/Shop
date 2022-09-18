package com.example.Shop.service.bean;

import com.example.Shop.entity.OrderItems;
import com.example.Shop.service.OrderItemsService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class OrderItemsServiceBean implements OrderItemsService {
    private Map<Integer, OrderItems> map = new HashMap<>();

    @Override
    public void add(OrderItems item) {
        OrderItems existedItem = map.get(item.getProduct().getId());
        if(existedItem != null) {
            existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
        } else {
            map.put(item.getProduct().getId(), item);
        }
    }

    @Override
    public void remove(Integer productId) {
        map.remove(productId);
    }

    @Override
    public Collection<OrderItems> getCartItem() {
        return map.values();
    }

    @Override
    public void update(Integer productId, Integer quantity) {
        OrderItems item = map.get(productId);

        item.setQuantity(quantity + item.getQuantity());

        if(item.getQuantity() <= 0) {
            map.remove(productId);
        }
    }

    @Override
    public Integer getCount() {
        return map.size();
    }

    @Override
    public String getAmount() {
        Double res = map.values().stream().mapToDouble(item->item.getQuantity() * item.getProduct().getPriceDouble()).sum();
        return String.format("%.3f", res) + "đ";
    }

}
