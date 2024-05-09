package com.example.foodorderingsystem.services.classes;

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
    public List<Dish> readAll() {
        return dishRepository.readAll();
    }

    @Override
    public Dish readById(long id) {
        return dishRepository.readById(id);
    }

    @Override
    public Dish readByName(String name) {
        return dishRepository.readByName(name);
    }

    @Override
    public Dish update(Dish dish) {
        return dishRepository.update(dish);
    }

    @Override
    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }
}
