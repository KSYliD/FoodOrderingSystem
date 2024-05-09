package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Drink;
import com.example.foodorderingsystem.services.interfaces.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/drink")
public class DrinkController {
    private DrinkService drinkService;

    @PostMapping
    public Drink save(@RequestBody Drink drink) {
        return drinkService.save(drink);
    }

    @GetMapping
    public List<Drink> findAll() {
        return drinkService.findAll();
    }

    @GetMapping("/{name}")
    public Drink findByName(@PathVariable String name) {
        return drinkService.findByName(name);
    }

    @PutMapping
    public Drink update(@RequestBody Drink drink) {
        return drinkService.update(drink);
    }

    @DeleteMapping
    public void delete(@RequestBody Drink drink) {
        drinkService.delete(drink);
    }
}
