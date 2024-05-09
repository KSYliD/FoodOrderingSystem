package com.example.foodorderingsystem.services.interfaces;

import com.example.foodorderingsystem.entities.Dessert;

import java.util.List;

public interface DessertService{
    Dessert save(Dessert dessert);
    List<Dessert> findAll();
    Dessert findById(long id);
    Dessert findByName(String name);
    Dessert update(Dessert dessert);
    void delete(Dessert dessert);
    boolean existsByName(String name);
}