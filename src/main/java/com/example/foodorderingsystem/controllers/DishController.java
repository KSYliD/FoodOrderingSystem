package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Dish;
import com.example.foodorderingsystem.services.interfaces.DishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dish")
public class DishController {
    private DishService dishService;

    @PostMapping
    public Dish save(Dish dish) {
        return dishService.save(dish);
    }

    @GetMapping
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/{name}")
    public Dish findByName(@PathVariable String name) {
        return dishService.findByName(name);
    }

    @PutMapping
    public Dish update(Dish dish) {
        return dishService.update(dish);
    }

    @DeleteMapping
    public void delete(Dish dish) {
        dishService.delete(dish);
    }
}
