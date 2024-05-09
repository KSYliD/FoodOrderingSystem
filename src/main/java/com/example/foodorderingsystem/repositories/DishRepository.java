package com.example.foodorderingsystem.repositories;

import com.example.foodorderingsystem.entities.Dish;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    @NotNull
    Dish save(@NotNull Dish dish);
    Dish findById(long id);
    Dish findByName(String name);
    void delete(@NotNull Dish dish);
    boolean existsByName(String name);
}
