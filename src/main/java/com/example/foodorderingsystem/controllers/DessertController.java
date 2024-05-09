package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Dessert;
import com.example.foodorderingsystem.services.interfaces.DessertService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dessert")
public class DessertController {
    private DessertService dessertService;

    @PostMapping
    public Dessert save(@RequestBody Dessert dessert) {
        return dessertService.save(dessert);
    }

    @GetMapping
    public List<Dessert> findAll() {
        return dessertService.findAll();
    }

    @GetMapping("/{name}")
    public Dessert findByName(@PathVariable String name) {
        return dessertService.findByName(name);
    }

    @PutMapping
    public Dessert update(@RequestBody Dessert dessert) {
        return dessertService.update(dessert);
    }

    @DeleteMapping
    public void delete(@RequestBody Dessert dessert) {
        dessertService.delete(dessert);
    }
}
