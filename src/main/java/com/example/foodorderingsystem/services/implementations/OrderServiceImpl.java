package com.example.foodorderingsystem.services.classes;

import com.example.foodorderingsystem.entities.Order;
import com.example.foodorderingsystem.repositories.OrderRepository;
import com.example.foodorderingsystem.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.readAll();
    }

    @Override
    public Order readById(long id) {
        return orderRepository.readById(id);
    }

    @Override
    public Order readByName(String name) {
        return orderRepository.readByName(name);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
