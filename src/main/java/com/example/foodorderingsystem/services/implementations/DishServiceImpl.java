package com.example.foodorderingsystem.services.implementations;

import com.example.foodorderingsystem.entities.Dish;
import com.example.foodorderingsystem.repositories.DishRepository;
import com.example.foodorderingsystem.services.interfaces.DishService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {
    private DishRepository dishRepository;

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(long id) {
        return dishRepository.findById(id);
    }

    @Override
    public Dish findByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public Dish update(Dish dish) {
        Dish dishData = dishRepository.findById(dish.getId());
        dishData.setName(dish.getName());
        dishData.setPrice(dish.getPrice());
        dishData.setDetails(dish.getDetails());
        dishData.setCuisine(dish.getCuisine());
        return dishRepository.save(dishData);

    }

    @Override
    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    @Override
    public boolean existsByName(String name) {
        return dishRepository.existsByName(name);
    }
}
