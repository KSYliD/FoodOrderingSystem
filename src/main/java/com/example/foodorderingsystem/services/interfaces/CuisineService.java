package com.example.foodorderingsystem.services.interfaces;

import com.example.foodorderingsystem.entities.Cuisine;

import java.util.List;

public interface CuisineService {
    Cuisine save(Cuisine cuisine);
    List<Cuisine> findAll();
    Cuisine findById(long id);
    Cuisine findByName(String name);
    Cuisine update(Cuisine cuisine);
    void delete(Cuisine cuisine);
    boolean existsByName(String name);
}
