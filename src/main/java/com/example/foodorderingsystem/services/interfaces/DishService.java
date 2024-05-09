package com.example.foodorderingsystem.services.interfaces;

import com.example.foodorderingsystem.entities.Dish;

import java.util.List;

public interface DishService {
    Dish save(Dish dish);
    List<Dish> findAll();
    Dish findById(long id);
    Dish findByName(String name);
    Dish update(Dish dish);
    void delete(Dish dish);
    boolean existsByName(String name);
}
