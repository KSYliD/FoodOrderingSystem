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
    public List<Dessert> readAll() {
        return dessertRepository.readAll();
    }

    @Override
    public Dessert readById(long id) {
        return dessertRepository.readById(id);
    }

    @Override
    public Dessert readByName(String name) {
        return dessertRepository.readByName(name);
    }

    @Override
    public Dessert update(Dessert dessert) {
        return dessertRepository.update(dessert);
    }

    @Override
    public void delete(Dessert dessert) {
        dessertRepository.delete(dessert);
    }
}
