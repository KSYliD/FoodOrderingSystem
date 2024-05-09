package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Order;
import com.example.foodorderingsystem.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public Order orderFood(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping
    public void delete(@RequestBody Order order) {
        orderService.delete(order);
    }
}
