package com.example.foodorderingsystem.services.implementations;

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
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink findById(long id) {
        return drinkRepository.findById(id);
    }

    @Override
    public Drink findByName(String name) {
        return drinkRepository.findByName(name);
    }

    @Override
    public Drink update(Drink drink) {
        Drink drinkData = drinkRepository.findById(drink.getId());
        drinkData.setName(drink.getName());
        drinkData.setPrice(drink.getPrice());
        drinkData.setDetails(drink.getDetails());
        return drinkRepository.save(drinkData);

    }

    @Override
    public void delete(Drink drink) {
        drinkRepository.delete(drink);
    }

    @Override
    public boolean existsByName(String name) {
        return drinkRepository.existsByName(name);
    }
}
