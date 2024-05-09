package com.example.foodorderingsystem.services.interfaces;

import com.example.foodorderingsystem.entities.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);
    List<Order> findAll();
    Order findById(long id);
    Order update(Order order);
    void delete(Order order);
}
