package com.example.foodorderingsystem.services.classes;

import com.example.foodorderingsystem.entities.Drink;
import com.example.foodorderingsystem.repositories.DrinkRepository;
import com.example.foodorderingsystem.services.interfaces.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DrinkServiceImpl implements DrinkService {
    private DrinkRepository drinkRepository;

    @Override
    public Drink save(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public List<Drink> readAll() {
        return drinkRepository.readAll();
    }

    @Override
    public Drink readById(long id) {
        return drinkRepository.readById(id);
    }

    @Override
    public Drink readByName(String name) {
        return drinkRepository.readByName(name);
    }

    @Override
    public Drink update(Drink drink) {
        return drinkRepository.update(drink);
    }

    @Override
    public void delete(Drink drink) {
        drinkRepository.delete(drink);
    }
}
