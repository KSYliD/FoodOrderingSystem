package com.example.foodorderingsystem.services.interfaces;

import com.example.foodorderingsystem.entities.Drink;

import java.util.List;

public interface DrinkService {
    Drink save(Drink drink);
    List<Drink> findAll();
    Drink findById(long id);
    Drink findByName(String name);
    Drink update(Drink drink);
    void delete(Drink drink);
    boolean existsByName(String name);
}
