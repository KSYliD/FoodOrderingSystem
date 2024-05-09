package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Dessert;
import com.example.foodorderingsystem.repositories.DessertRepository;
import com.example.foodorderingsystem.services.interfaces.DessertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DessertServiceImpl implements DessertService {
    private DessertRepository dessertRepository;


    @Override
    public Dessert save(Dessert dessert) {
        return dessertRepository.save(dessert);
    }

    @Override
    public List<Dessert> findAll() {
        return dessertRepository.findAll();
    }

    @Override
    public Dessert findById(long id) {
        return dessertRepository.findById(id);
    }

    @Override
    public Dessert findByName(String name) {
        return dessertRepository.findByName(name);
    }

    @Override
    public Dessert update(Dessert dessert) {
        Dessert dessertData = dessertRepository.findById(dessert.getId());
        dessertData.setName(dessert.getName());
        dessertData.setPrice(dessert.getPrice());
        dessertData.setDetails(dessert.getDetails());
        dessertData.setCuisine(dessert.getCuisine());
        return dessertRepository.save(dessertData);

    }

    @Override
    public void delete(Dessert dessert) {
        dessertRepository.delete(dessert);
    }

    @Override
    public boolean existsByName(String name) {
        return dessertRepository.existsByName(name);
    }
}
