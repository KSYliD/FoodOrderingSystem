package com.example.foodorderingsystem.services.implementations;

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
    public List<Cuisine> findAll() {
        return cuisineRepository.findAll();
    }

    @Override
    public Cuisine findById(long id) {
        return cuisineRepository.findById(id);
    }

    @Override
    public Cuisine findByName(String name) {
        return cuisineRepository.findByName(name);
    }

    @Override
    public Cuisine update(Cuisine cuisine) {
        Cuisine cuisineData = cuisineRepository.findById(cuisine.getId());
        cuisineData.setName(cuisine.getName());
        return cuisineRepository.save(cuisineData);

    }

    @Override
    public void delete(Cuisine cuisine) {
        cuisineRepository.delete(cuisine);
    }

    @Override
    public boolean existsByName(String name) {
        return cuisineRepository.existsByName(name);
    }

}
