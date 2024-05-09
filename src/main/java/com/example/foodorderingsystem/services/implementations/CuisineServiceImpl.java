package com.example.foodorderingsystem.services.classes;

import com.example.foodorderingsystem.entities.Cuisine;
import com.example.foodorderingsystem.repositories.CuisineRepository;
import com.example.foodorderingsystem.services.interfaces.CuisineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuisineServiceImpl implements CuisineService {
    private CuisineRepository cuisineRepository;

    @Override
    public Cuisine save(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }

    @Override
    public List<Cuisine> readAll() {
        return cuisineRepository.readAll();
    }

    @Override
    public Cuisine readById(long id) {
        return cuisineRepository.readById(id);
    }

    @Override
    public Cuisine readByName(String name) {
        return cuisineRepository.readByName(name);
    }

    @Override
    public Cuisine update(Cuisine cuisine) {
        return cuisineRepository.update(cuisine);
    }

    @Override
    public void delete(Cuisine cuisine) {
        cuisineRepository.delete(cuisine);
    }
}
