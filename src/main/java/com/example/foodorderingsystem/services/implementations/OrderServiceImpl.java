package com.example.foodorderingsystem.services.implementations;

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
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order update(Order order) {
        Order orderData = orderRepository.findById(order.getId());
        orderData.setTableNum(order.getTableNum());
        orderData.setMainCourse(order.getMainCourse());
        orderData.setDessert(order.getDessert());
        orderData.setDrink(order.getDrink());
        orderData.setDetails(order.getDetails());
        return orderRepository.save(orderData);

    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
