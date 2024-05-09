package com.example.foodorderingsystem.controllers;

import com.example.foodorderingsystem.entities.Cuisine;
import com.example.foodorderingsystem.services.interfaces.CuisineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cuisine")
public class CuisineController {
    private CuisineService cuisineService;

    @PostMapping
    public Cuisine save(@RequestBody Cuisine cuisine) {
        return cuisineService.save(cuisine);
    }

    @GetMapping
    public List<Cuisine> findAll() {
        return cuisineService.findAll();
    }

    @GetMapping("/{name}")
    public Cuisine findByName(@PathVariable String name) {
        return cuisineService.findByName(name);
    }

    @PutMapping
    public Cuisine update(@RequestBody Cuisine cuisine) {
        return cuisineService.update(cuisine);
    }

    @DeleteMapping
    public void delete(@RequestBody Cuisine cuisine) {
        cuisineService.delete(cuisine);
    }
}
